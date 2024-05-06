package com.mastercard.sanctions.casemanager.entities;

import java.sql.Timestamp;

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
@Table(name = "communication_dtl")
public class Communication {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "case_comm_id", columnDefinition = "VARCHAR(255)")
	private String caseCommunicationId;

	@Column(name = "cust_cid")
	private String customerCID;

	private Timestamp customerOutReachDate;

	private String customerOutReachContact;

	private Timestamp customerReplyDate;
	
	private Timestamp customerBlockDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
	private Cases caseId;

}