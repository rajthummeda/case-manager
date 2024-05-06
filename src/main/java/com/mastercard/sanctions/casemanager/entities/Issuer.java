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
@Table(name = "issuer_dtl")
public class Issuer {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "case_issuer_id", columnDefinition = "VARCHAR(255)")
    private String caseIssuerId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id")
    private Cases caseId;
    
    @Column(name = "issuer_ica")
    private String issuerICA;

    @Column(name = "issuer_cid")
    private String issuerCID;

    @Column(name = "issuer_name")
    private String issuerName;

    @Column(name = "issuer_country_code")
    private String issuerCountryCode;

    @Column(name = "issuer_country_name")
    private String issuerCountryName;

    @Column(name = "issuer_region_name")
    private String issuerRegionName;
}