package com.kognitiv.org;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kognitiv.org.collectoffer.controller.CollectOfferController;
import com.kognitiv.org.collectoffer.model.CreateOfferRequestModel;
import com.kognitiv.org.collectoffer.model.CreateOfferResponseModel;
import com.kognitiv.org.collectoffer.service.CollectOfferService;
import com.kognitiv.org.collectoffer.service.RestService;

@SpringBootTest
public class CollectOfferControllerTest {

	@InjectMocks
	CollectOfferController collectOfferController;

	@Mock
	private CollectOfferService collectOfferService;

	@Mock
	private RestService restService;

	@Mock
	private ModelMapper modelMapper;

	@Test
	public void testCreateOffer() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder
				.setRequestAttributes(new ServletRequestAttributes(request));

		CreateOfferRequestModel offer = new CreateOfferRequestModel();
		offer.setName("NEWYEAR2021");
		offer.setValidFrom(LocalDate.parse("2021-01-20"));
		offer.setValidTill(LocalDate.parse("2021-06-20"));
		offer.setLocation("Delhi");

		ResponseEntity<CreateOfferResponseModel> responseEntity = collectOfferController
				.createOffer(offer);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseEntity.getBody().isSuccess());
	}

}
