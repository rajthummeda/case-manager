package com.mastercard.sanctions.casemanager.entities;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "case_dtl")
public class Cases {
	
    @Id
    @GeneratedValue(generator = "case_id_generator")
    @GenericGenerator(name = "case_id_generator", strategy = "com.mastercard.sanctions.casemanager.util.CaseIdGenerator")
    @Column(name = "case_id")
    private String caseId;

    @Column(name = "type_of_case")
    private String typeOfCase;
    
    @Column(name = "case_owner")
    private String caseOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_type_id")
    private CaseType caseType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;
    
    @Column(name = "src_name")
    private String sourceName;

    @Enumerated(EnumType.STRING)
    @Column(name = "case_status")
    private Status caseStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "case_priority")
    private Priority casePriority;
    
    @Column(name = "opn_dt")
    @Temporal(TemporalType.DATE)
    private Date openDate;
    
    @Column(name = "closure_rsn")
    private String closureReason;
    
    @Column(name = "assign_to")
    private String assignedTo;
    
    @Column(name = "close_dt")
    @Temporal(TemporalType.DATE)
    private Date closingDate;
    
    private String field1;
    private String field2;
    private String field3;
}