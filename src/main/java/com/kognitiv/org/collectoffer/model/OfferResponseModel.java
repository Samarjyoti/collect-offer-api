package com.kognitiv.org.collectoffer.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferResponseModel {

	@XmlElement private String name;
	@XmlElement private String id;
	@XmlElement private LocalDate validFrom;
	@XmlElement private LocalDate validTill;
	@XmlElement private String location;
	@XmlElement private ImageResponseModel image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}
	public LocalDate getValidTill() {
		return validTill;
	}
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ImageResponseModel getImage() {
		return image;
	}
	public void setImage(ImageResponseModel image) {
		this.image = image;
	}

}
