package com.mastercard.sanctions.casemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mastercard.sanctions.casemanager.entities.CaseTypeDetails;

@Repository
public interface CaseTypeDetailsRepository extends JpaRepository<CaseTypeDetails, Long> {

}
