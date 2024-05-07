package com.mastercard.sanctions.casemanager.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mastercard.sanctions.casemanager.dto.CaseDetailsDto;
import com.mastercard.sanctions.casemanager.dto.SaveCaseDto;
import com.mastercard.sanctions.casemanager.service.CaseService;

@RestController
@RequestMapping("/api/cases")
public class CaseController {

    @Autowired
    private CaseService casesService;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createCase(@RequestBody SaveCaseDto caseDto) {
        Map<String, Object> response = casesService.createCase(caseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/{type}")
    public ResponseEntity<List<CaseDetailsDto>> getCasesByType(@PathVariable("type") String type) {
        List<CaseDetailsDto> casesList = casesService.getCasesByType(type);
        return ResponseEntity.ok(casesList);
    }
}