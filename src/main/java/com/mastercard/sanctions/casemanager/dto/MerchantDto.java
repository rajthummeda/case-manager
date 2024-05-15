package com.mastercard.sanctions.casemanager.dto;

import lombok.Data;

@Data
public class MerchantDto {

	private String merchantId;
	private String merchantName;
	private String merchantCountryCode;
}
