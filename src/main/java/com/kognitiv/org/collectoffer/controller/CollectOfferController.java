package com.kognitiv.org.collectoffer.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kognitiv.org.collectoffer.dto.OfferDto;
import com.kognitiv.org.collectoffer.model.CreateOfferRequestModel;
import com.kognitiv.org.collectoffer.model.CreateOfferResponseModel;
import com.kognitiv.org.collectoffer.model.ErrorMessage;
import com.kognitiv.org.collectoffer.model.GetOfferResponseModel;
import com.kognitiv.org.collectoffer.model.OfferResponseModel;
import com.kognitiv.org.collectoffer.service.CollectOfferService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class CollectOfferController {

	@Autowired
	private CollectOfferService collectOfferService;

	@Autowired
	private ModelMapper modelMapper;

	@ApiOperation(value = "getOffer")
	@RequestMapping(method = RequestMethod.GET, value = "/collect/offer", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE})
	public ResponseEntity<GetOfferResponseModel> getOffers(
			@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {

		Page<OfferDto> offerDtoPage;
		GetOfferResponseModel response = new GetOfferResponseModel();
		List<OfferResponseModel> offerList = new ArrayList<>();

		try {
			Pageable paging = PageRequest.of(page, size);
			if (name == null)
				offerDtoPage = collectOfferService.getOffers(paging);
			else
				offerDtoPage = collectOfferService.getOfferByName(name, paging);

			if (!offerDtoPage.isEmpty()) {
				response.setSuccess(true);
				offerList = offerDtoPage.getContent().stream()
						.map(offer -> modelMapper.map(offer,
								OfferResponseModel.class))
						.collect(Collectors.toList());
				response.setOffers(offerList);
			} else {
				response.setSuccess(false);
				response.setOffers(new ArrayList<>());
			}

			response.setCurrentPage(offerDtoPage.getNumber());
			response.setTotalItems(offerDtoPage.getTotalElements());
			response.setTotalPages(offerDtoPage.getTotalPages());

			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					e.getMessage(), e);
		}
	}

	@ApiOperation(value = "createOffer")
	@RequestMapping(method = RequestMethod.POST, value = "/collect/offer", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE})
	public ResponseEntity<CreateOfferResponseModel> createOffer(
			@Valid @RequestBody CreateOfferRequestModel offer) {

		OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
		OfferDto createdOffer = collectOfferService.createOffer(offerDto);

		CreateOfferResponseModel returnValue = modelMapper.map(createdOffer,
				CreateOfferResponseModel.class);
		if (createdOffer != null)
			returnValue.setSuccess(true);
		else
			returnValue.setSuccess(false);

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

	@ApiOperation(value = "createOffers")
	@RequestMapping(method = RequestMethod.POST, value = "/collect/offers", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE})
	public ResponseEntity<List<CreateOfferResponseModel>> createOffers(
			@RequestBody List<CreateOfferRequestModel> offers) {

		List<CreateOfferResponseModel> responseList = new ArrayList<>();
		for (CreateOfferRequestModel offer : offers) {
			OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
			OfferDto createdOffer = collectOfferService.createOffer(offerDto);

			CreateOfferResponseModel returnValue = modelMapper.map(createdOffer,
					CreateOfferResponseModel.class);
			if (createdOffer != null)
				returnValue.setSuccess(true);
			else
				returnValue.setSuccess(false);
			responseList.add(returnValue);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(responseList);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Object> validationError(
			MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		final List<FieldError> fieldErrors = result.getFieldErrors();
		ErrorMessage errorMessage = new ErrorMessage(new Date(),
				fieldErrors.get(0).getDefaultMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
