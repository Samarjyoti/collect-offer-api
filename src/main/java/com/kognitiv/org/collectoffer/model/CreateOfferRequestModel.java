	package com.kognitiv.org.collectoffer.model;
	
	import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
	
	public class CreateOfferRequestModel {
	
		@NotNull(message = "Null value not accepted")
		@NotEmpty(message = "Empty value not accepted")
		private String name;
	
		@NotNull(message = "Null value not accepted")
		private LocalDate validFrom;
	
		@NotNull(message = "Null value not accepted")
		private LocalDate validTill;
	
		@NotNull(message = "Null value not accepted")
		@NotEmpty(message = "Empty value not accepted")
		private String location;

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
	
	
	}
