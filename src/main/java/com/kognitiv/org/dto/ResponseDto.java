package com.kognitiv.org.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ResponseDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDto {

	@XmlElement private boolean success;
	@XmlElement private List<OfferDto> data;

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<OfferDto> getData() {
		return data;
	}

	public void setData(List<OfferDto> data) {
		this.data = data;
	}

}
