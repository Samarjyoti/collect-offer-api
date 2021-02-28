package com.kognitiv.org.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kognitiv.org.entity.Image;

public interface CollectOfferImageRepository extends JpaRepository<Image, Long> {

}
