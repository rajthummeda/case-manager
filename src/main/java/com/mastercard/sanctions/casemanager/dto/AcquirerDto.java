package com.mastercard.sanctions.casemanager.dto;

import lombok.Data;

@Data
public class AcquirerDto {
	
	private String acquirerId;
	private String acquirerName;
    private String acquirerCountryCode;
    private String acquirerICA;
}
