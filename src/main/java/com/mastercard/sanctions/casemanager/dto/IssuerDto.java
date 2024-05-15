package com.mastercard.sanctions.casemanager.dto;

import lombok.Data;

@Data
public class IssuerDto {

	private String issuerId;
    private String issuerName;
    private String issuerICA;
    private String issuerCountryCode;
}
