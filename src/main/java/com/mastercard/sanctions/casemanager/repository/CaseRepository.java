package com.mastercard.sanctions.casemanager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastercard.sanctions.casemanager.entities.Cases;

@Repository
public interface CaseRepository extends JpaRepository<Cases, String> {

    List<Cases> findByTypeOfCase(String type);

}
