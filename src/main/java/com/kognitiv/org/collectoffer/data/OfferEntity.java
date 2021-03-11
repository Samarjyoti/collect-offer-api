package com.kognitiv.org.collectoffer.data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Offer")
public class OfferEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true, nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private LocalDate validFrom;

	@Column(nullable = false)
	private LocalDate validTill;

	@Column(nullable = false)
	private String location;
	
	
	@OneToOne
	private ImageEntity image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public ImageEntity getImage() {
		return image;
	}

	public void setImage(ImageEntity image) {
		this.image = image;
	}

}
