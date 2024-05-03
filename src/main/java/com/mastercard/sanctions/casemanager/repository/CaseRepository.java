package com.mastercard.sanctions.casemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercard.sanctions.casemanager.entities.Cases;

public interface CaseRepository extends JpaRepository<Cases, String> {

    List<Cases> findByTypeOfCase(String type);

}
