package com.mastercard.sanctions.casemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercard.sanctions.casemanager.entities.CaseTypeDetails;

public interface CaseTypeDetailsRepository extends JpaRepository<CaseTypeDetails, Long> {

}
