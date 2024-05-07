package com.mastercard.sanctions.casemanager.dto;

public enum CaseTypeEnum {
    INTERNAL_INQUIRY("Internal Inquiry"),
    EXTERNAL_INQUIRY("External Inquiry"),
    PRODUCT_REVIEW("Product Review"),
    CUSTOMER_INQUIRY("Customer Inquiry"),
    GOVERNMENT_REGULATOR("Government-Regulator"),
	LAW_ENFORCEMENT("Law Enforcement");

    private final String type;

    CaseTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static CaseTypeEnum fromString(String text) {
        for (CaseTypeEnum caseType : CaseTypeEnum.values()) {
            if (caseType.type.equalsIgnoreCase(text)) {
                return caseType;
            }
        }
        throw new IllegalArgumentException("No constant with type " + text + " found in CaseTypeEnum");
    }
}

