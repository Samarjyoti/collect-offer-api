package com.kognitiv.org.api;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket getOfferApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/collect/offer*"))
                .build().apiInfo(getApiInfo());
    }
	
	  private ApiInfo getApiInfo() {
	        return new ApiInfo(
	                "Collect Offer API",
	                "This is a Spring Boot RESTful service of Collect Offer API using SpringFox + Swagger 2",
	                "V1",
	                "urn:tos",
	                new Contact("Samarjyoti Das", "https://www.google.com", "xyz@gmail.com"),
	                "CC BY-IN 3.0",
	                "https://creativecommons.org/licenses/by-sa/3.0/",
	                Collections.emptyList()
	        );
	  }

}
