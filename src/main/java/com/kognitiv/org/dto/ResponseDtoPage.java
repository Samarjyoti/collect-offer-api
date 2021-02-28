package com.kognitiv.org.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDtoPage {

	@XmlElement
	private ResponseDto offers;
	@XmlElement
	private long totalItems;
	@XmlElement
	private int totalPages;
	@XmlElement
	private int currentPage;
	public ResponseDto getOffers() {
		return offers;
	}
	public void setOffers(ResponseDto offers) {
		this.offers = offers;
	}
	public long getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(long l) {
		this.totalItems = l;
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
