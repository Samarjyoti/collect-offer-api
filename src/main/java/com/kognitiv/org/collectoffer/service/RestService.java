package com.kognitiv.org.collectoffer.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kognitiv.org.collectoffer.dto.ImageDto;

@Service
public class RestService {

	private final RestTemplate restTemplate;

	public RestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public ImageDto getPostsPlainJSON(long id) {
		String url = "http://jsonplaceholder.typicode.com/photos/"+id;
		return this.restTemplate.getForObject(url, ImageDto.class);
	}

}
