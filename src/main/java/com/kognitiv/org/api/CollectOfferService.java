package com.kognitiv.org.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kognitiv.org.entity.Offer;

@Service
public class CollectOfferService {

	@Autowired
	private CollectOfferRepository repository;
	@Autowired
	private CollectOfferImageRepository imageRepository;

	// public Offer getOfferById(long id) throws Exception {
	//
	// Optional<Offer> offer = repository.findById(id);
	// if (offer.isPresent())
	// return offer.get();
	// else
	// throw new Exception("Offer with given ID not present");
	// }

	public Offer createOffer(Offer offer) {
		imageRepository.save(offer.getImage());
		return repository.save(offer);
	}

	public Page<Offer> getOffers(Pageable paging) {
		return repository.findAll(paging);
	}

	public Page<Offer> getOfferByName(String name, Pageable paging) {
		return repository.findByName(name, paging);
	}

}
