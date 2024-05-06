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
@Table(name = "attachment_dtl")
public class Attachments {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "case_attach_id", columnDefinition = "VARCHAR(255)")
	private String caseAttachmentId;
	
	@Column(name = "doc_desc")
	private String description;
	
	@Column(name = "doc_name")
	private String name;

	@Column(name = "doc_type")
	private String type;
	
	@Column(name = "doc_path")
	private String path;
	
	@Column(name = "doc_size")
	private String size;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
	private Cases caseId;
}