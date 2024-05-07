package com.mastercard.sanctions.casemanager.dto;

import lombok.Data;

@Data
public class CaseTypeDetailsDto {

	private String topic;

	private String businessLine;

	private String caseNotes;

	private String region;

	private String country;

	private String contactNameInfo;

	private String actionTaken;

	private String dueDate;

	private String customerCId;

	private String customerName;

	private String productName;

	private String agencyName;

}
