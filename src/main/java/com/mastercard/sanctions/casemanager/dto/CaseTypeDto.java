package com.mastercard.sanctions.casemanager.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CaseTypeDto {

	private String type;
	private String topic;
	private String businessLine;
	private String description;
	private String region;
	private String country;
	private String contactNameInfo;
	private String actionTaken;
	private Date dueDate;
	private String customerId;
	private String customerName;
	private String productName;
	private String agencyName;
}
