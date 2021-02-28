package com.kognitiv.org.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kognitiv.org.entity.Offer;

public interface CollectOfferRepository extends JpaRepository<Offer, Long> {

	Page<Offer> findByName(String name, Pageable pageable);

}
