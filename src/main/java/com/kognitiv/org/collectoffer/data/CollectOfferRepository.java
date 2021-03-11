package com.kognitiv.org.collectoffer.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectOfferRepository extends JpaRepository<OfferEntity, Long> {

	Page<OfferEntity> findByName(String name, Pageable pageable);

}
