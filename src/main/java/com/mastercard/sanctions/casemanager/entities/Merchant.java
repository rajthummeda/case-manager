package com.mastercard.sanctions.casemanager.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "merchant_dtl")
public class Merchant {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "case_merchant_id", columnDefinition = "VARCHAR(255)")
    private String caseMerchantId;

    @Column(name = "merchant_id")
    private String merchantId;
    
    @Column(name = "merchant_name")
    private String merchantName;
    
    private String merchantCategoryCode;
    
    private String merchantCategoryName;
    
    private String merchantCountryName;
    
    private String merchantCountryCode;
    
    private String merchantAddress;
    
    private String merchantRegion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id")
    private Cases caseId;
}