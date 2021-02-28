package com.kognitiv.org.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kognitiv.org.dto.OfferDto;
import com.kognitiv.org.dto.ResponseDto;
import com.kognitiv.org.dto.ResponseDtoPage;
import com.kognitiv.org.entity.Image;
import com.kognitiv.org.entity.Offer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class CollectOfferController {

	@Autowired
	private CollectOfferService collectOfferService;

	@Autowired
	private RestService restService;

	@Autowired
	private ModelMapper modelMapper;

	@ApiOperation(value = "getOffer")
	@RequestMapping(method = RequestMethod.GET, value = "/collect/offer", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE})
	public ResponseEntity<ResponseDtoPage> getOffers(
			@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {

		Page<Offer> offerPage;
		ResponseDto response = new ResponseDto();
		List<OfferDto> offerDtoList = new ArrayList<>();

		try {
			Pageable paging = PageRequest.of(page, size);
			if (name == null)
				offerPage = collectOfferService.getOffers(paging);
			else
				offerPage = collectOfferService.getOfferByName(name, paging);

			if (!offerPage.isEmpty()) {
				response.setSuccess(true);
				offerDtoList = offerPage.getContent().stream()
						.map(offer -> modelMapper.map(offer, OfferDto.class))
						.collect(Collectors.toList());
				response.setData(offerDtoList);
			} else {
				response.setSuccess(false);
				response.setData(new ArrayList<>());
			}

			ResponseDtoPage resPage = new ResponseDtoPage();
			resPage.setOffers(response);
			resPage.setCurrentPage(offerPage.getNumber());
			resPage.setTotalItems(offerPage.getTotalElements());
			resPage.setTotalPages(offerPage.getTotalPages());

			return new ResponseEntity<>(resPage, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					e.getMessage(), e);
		}
	}

	@ApiOperation(value = "createOffer")
	@RequestMapping(method = RequestMethod.POST, value = "/collect/offer", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE})
	public ResponseEntity<ResponseDto> createOffer(@RequestBody Offer offer) {

		try {
			long imageId = (long) (Math.random() * 5000);
			Image image = restService.getPostsPlainJSON(imageId);
			offer.setImage(image);

			offer = collectOfferService.createOffer(offer);
			ResponseDto response = new ResponseDto();
			if (offer != null)
				response.setSuccess(true);
			else
				response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					e.getMessage(), e);
		}
	}

	@ApiOperation(value = "createOffers")
	@RequestMapping(method = RequestMethod.POST, value = "/collect/offers", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE})
	public ResponseEntity<List<ResponseDto>> createOffers(
			@RequestBody List<Offer> offers) {

		try {
			List<ResponseDto> responseList = new ArrayList<>();
			for (Offer offer : offers) {
				long imageId = (long) (Math.random() * 5000);
				Image image = restService.getPostsPlainJSON(imageId);
				offer.setImage(image);

				offer = collectOfferService.createOffer(offer);
				ResponseDto response = new ResponseDto();
				if (offer != null)
					response.setSuccess(true);
				else
					response.setSuccess(false);
				responseList.add(response);
			}
			return new ResponseEntity<>(responseList, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					e.getMessage(), e);
		}
	}

}
