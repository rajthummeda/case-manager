package com.mastercard.sanctions.casemanager.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "case_type")
public class CaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_type_id")
    private Long caseTypeId;

    @Column(name = "type_name")
    private String typeName;

    private String topic;

    @Column(name = "business_line")
    private String businessLine;

    @Lob
    @Column(name = "case_notes")
    private String caseNotes;

    private String region;

    private String country;

    @Column(name = "contact_name_info")
    private String contactNameInfo;

    @Column(name = "action_taken")
    private String actionTaken;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "customer_cid")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "agency_name")
    private String agencyName;

    private String field1;
    private String field2;
    private String field3;

    // Constructors, getters, and setters
}

