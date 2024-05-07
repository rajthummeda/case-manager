package com.mastercard.sanctions.casemanager.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.sanctions.casemanager.dto.CaseTypeDto;
import com.mastercard.sanctions.casemanager.service.CaseTypeService;

@RestController
@RequestMapping("/api/case-types")
public class CaseTypeController {

    @Autowired
    private CaseTypeService caseTypeService;

    @PostMapping("/save")
    public ResponseEntity<CaseTypeDto> saveCaseType(@RequestBody CaseTypeDto caseTypeDto) {
        CaseTypeDto savedCaseTypeDto = caseTypeService.saveCaseType(caseTypeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCaseTypeDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CaseTypeDto> updateCaseType(@PathVariable Long id, @RequestBody CaseTypeDto caseTypeDto) {
        CaseTypeDto updatedCaseTypeDto = caseTypeService.updateCaseType(id, caseTypeDto);
        return ResponseEntity.ok(updatedCaseTypeDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CaseTypeDto> getCaseTypeById(@PathVariable Long id) {
        CaseTypeDto caseTypeDto = caseTypeService.getCaseTypeById(id);
        return ResponseEntity.ok(caseTypeDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CaseTypeDto>> getAllCaseTypes() {
        List<CaseTypeDto> caseTypeDtoList = caseTypeService.getAllCaseTypes();
        return ResponseEntity.ok(caseTypeDtoList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCaseType(@PathVariable Long id) {
        caseTypeService.deleteCaseType(id);
        return ResponseEntity.ok("CaseType with ID " + id + " deleted successfully");
    }
}