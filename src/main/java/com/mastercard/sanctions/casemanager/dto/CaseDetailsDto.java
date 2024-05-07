package com.mastercard.sanctions.casemanager.dto;

import java.util.Date;

import com.mastercard.sanctions.casemanager.entities.Priority;
import com.mastercard.sanctions.casemanager.entities.Status;

import lombok.Data;

@Data
public class CaseDetailsDto {

	private String caseId;
    private String typeOfCase;
    private String caseOwner;
    private String sourceName;
    private Status caseStatus;
    private Priority casePriority;
    private Date openDate;
    private String closureReason;
    private Date closingDate;
    private String caseType;
    private String assignedTo;
    private CaseTypeDetailsDto caseTypeData;
    private IssuerDto issuer;
    private AcquirerDto acquirer;
}
