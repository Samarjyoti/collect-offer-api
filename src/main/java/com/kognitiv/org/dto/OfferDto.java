package com.kognitiv.org.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDto {
	
	@XmlElement private String offerId;
	@XmlElement private String offerName;
	@XmlElement private String offerValidFrom;
	@XmlElement private String offerValidTill;
	@XmlElement private String offerLocation;
	
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferValidFrom() {
		return offerValidFrom;
	}
	public void setOfferValidFrom(String offerValidFrom) {
		this.offerValidFrom = offerValidFrom;
	}
	public String getOfferValidTill() {
		return offerValidTill;
	}
	public void setOfferValidTill(String offerValidTill) {
		this.offerValidTill = offerValidTill;
	}
	public String getOfferLocation() {
		return offerLocation;
	}
	public void setOfferLocation(String offerLocation) {
		this.offerLocation = offerLocation;
	}
	
	

}
