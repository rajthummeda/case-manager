package com.mastercard.sanctions.casemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercard.sanctions.casemanager.entities.CaseType;

public interface CaseTypeRepository extends JpaRepository<CaseType, Long> {

}
