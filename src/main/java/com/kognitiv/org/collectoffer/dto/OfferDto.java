package com.kognitiv.org.collectoffer.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class OfferDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -660162574497904645L;
	private String id;
	private String name;
	private LocalDate validFrom;
	private LocalDate validTill;
	private String location;
	private ImageDto image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public ImageDto getImage() {
		return image;
	}
	public void setImage(ImageDto image) {
		this.image = image;
	}

}
