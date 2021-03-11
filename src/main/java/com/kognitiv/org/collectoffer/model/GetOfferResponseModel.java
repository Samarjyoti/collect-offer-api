package com.kognitiv.org.collectoffer.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOfferResponseModel {
	
	@XmlElement boolean success;
	@XmlElement private long totalItems;
	@XmlElement private int totalPages;
	@XmlElement private int currentPage;
	@XmlElement private List<OfferResponseModel> offers;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<OfferResponseModel> getOffers() {
		return offers;
	}
	public void setOffers(List<OfferResponseModel> offers) {
		this.offers = offers;
	}
	public long getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
