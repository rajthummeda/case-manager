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
@Table(name = "acquirer_dtl")
public class Acquirer {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "case_acq_id", columnDefinition = "VARCHAR(255)")
	private String caseAcquirerId;
	
	@Column(name = "acq_id")
	private String acquirerIcaOrRtn;
	
	private String acquirerCID;
	
	@Column(name = "acquirer_name")
	private String acquirerName;
	
	private String acquirerCountryCode;
	
	private String acquirerCountryName;
	
	private String acquirerRegionName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
	private Cases caseId;
}