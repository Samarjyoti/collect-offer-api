package com.kognitiv.org.collectoffer.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kognitiv.org.collectoffer.data.CollectOfferImageRepository;
import com.kognitiv.org.collectoffer.data.CollectOfferRepository;
import com.kognitiv.org.collectoffer.data.OfferEntity;
import com.kognitiv.org.collectoffer.dto.ImageDto;
import com.kognitiv.org.collectoffer.dto.OfferDto;

@Service
public class CollectOfferService {

	@Autowired
	private CollectOfferRepository repository;
	@Autowired
	private CollectOfferImageRepository imageRepository;
	@Autowired
	private RestService restService;
	@Autowired
	ModelMapper modelMapper;

	public OfferDto createOffer(OfferDto offer) {

		long imageId = (long) (Math.random() * 5000);
		ImageDto image = restService.getPostsPlainJSON(imageId);
		offer.setImage(image);

		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT);

		OfferEntity offerEntity = modelMapper.map(offer, OfferEntity.class);
		imageRepository.save(offerEntity.getImage());
		repository.save(offerEntity);

		OfferDto returnObject = modelMapper.map(offerEntity, OfferDto.class);
		return returnObject;
	}

	public Page<OfferDto> getOffers(Pageable paging) {

		Page<OfferDto> offerDtoPage = repository.findAll(paging).map(
				offerEntity -> modelMapper.map(offerEntity, OfferDto.class));
		return offerDtoPage;
	}

	public Page<OfferDto> getOfferByName(String name, Pageable paging) {
		Page<OfferDto> offerDtoPage = repository.findByName(name, paging).map(
				offerEntity -> modelMapper.map(offerEntity, OfferDto.class));
		return offerDtoPage;
	}

}
