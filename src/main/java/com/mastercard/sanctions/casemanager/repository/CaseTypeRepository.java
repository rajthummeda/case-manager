package com.mastercard.sanctions.casemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mastercard.sanctions.casemanager.entities.CaseType;

@Repository
public interface CaseTypeRepository extends JpaRepository<CaseType, Long> {

	CaseType findByTypeIgnoreCase(String caseType);

}
