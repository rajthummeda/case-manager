package com.mastercard.sanctions.casemanager.dto;

public enum CustomerTypeEnum {
    ACQUIRER("Acquirer"),
    ISSUER("Issuer"),
    MERCHANT("Merchant");

    private final String type;

    CustomerTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static CustomerTypeEnum fromString(String text) {
        for (CustomerTypeEnum customerType : CustomerTypeEnum.values()) {
            if (customerType.type.equalsIgnoreCase(text)) {
                return customerType;
            }
        }
        throw new IllegalArgumentException("No constant with type " + text + " found in CustomerTypeEnum");
    }
}

