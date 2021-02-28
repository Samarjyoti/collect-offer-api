package com.kognitiv.test;

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

import com.kognitiv.org.api.CollectOfferController;
import com.kognitiv.org.api.CollectOfferService;
import com.kognitiv.org.api.RestService;
import com.kognitiv.org.dto.ResponseDto;
import com.kognitiv.org.entity.Offer;

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

		Offer offer = new Offer();
		offer.setName("NEWYEAR2021");
		offer.setValidFrom(LocalDate.parse("2021-01-20"));
		offer.setValidTill(LocalDate.parse("2021-06-20"));
		offer.setLocation("Delhi");

		ResponseEntity<ResponseDto> responseEntity = collectOfferController
				.createOffer(offer);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseEntity.getBody().getSuccess());
	}

}
