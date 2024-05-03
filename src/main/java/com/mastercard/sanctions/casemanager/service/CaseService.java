package com.mastercard.sanctions.casemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.sanctions.casemanager.dto.CaseDto;
import com.mastercard.sanctions.casemanager.dto.CaseTypeDto;
import com.mastercard.sanctions.casemanager.entities.CaseType;
import com.mastercard.sanctions.casemanager.entities.Cases;
import com.mastercard.sanctions.casemanager.repository.CaseRepository;
import com.mastercard.sanctions.casemanager.repository.CaseTypeRepository;

@Service
public class CaseService {

	@Autowired
	private CaseRepository casesRepository;

	@Autowired
	private CaseTypeRepository caseTypeRepository;

	public Map<String, Object> createCase(CaseDto caseDto) {
		
		Map<String, Object> response = new HashMap<>();
		
        // Create CaseType entity
        CaseTypeDto caseTypeDto = caseDto.getCaseType();
        CaseType caseType = new CaseType();
        BeanUtils.copyProperties(caseTypeDto, caseType);
        caseTypeRepository.save(caseType);

        // Create Cases entity
        Cases cases = new Cases();
        BeanUtils.copyProperties(caseDto, cases);
        cases.setCaseType(caseType);
        Cases savedCase = casesRepository.save(cases);

        response.put("message", "Case created successfully of type : " + savedCase.getTypeOfCase());
        response.put("caseId", savedCase.getCaseId());
        return response;
    }

    public CaseDto getCaseById(String caseId) {
        Optional<Cases> optionalCases = casesRepository.findById(caseId);
        if (optionalCases.isPresent()) {
            Cases cases = optionalCases.get();
            CaseDto caseDto = new CaseDto();
            BeanUtils.copyProperties(cases, caseDto);
            // Set CaseTypeDto
            CaseTypeDto caseTypeDto = new CaseTypeDto();
            BeanUtils.copyProperties(cases.getCaseType(), caseTypeDto);
            caseDto.setCaseType(caseTypeDto);
            return caseDto;
        }
        return null;
    }
    
    public List<CaseDto> getCasesByType(String type) {
        List<Cases> casesList = casesRepository.findByTypeOfCase(type);
        return casesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CaseDto> getAllCases() {
        List<Cases> casesList = casesRepository.findAll();
        return casesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CaseDto convertToDto(Cases cases) {
        CaseDto caseDto = new CaseDto();
        BeanUtils.copyProperties(cases, caseDto);
        // Set CaseTypeDto
        CaseTypeDto caseTypeDto = new CaseTypeDto();
        BeanUtils.copyProperties(cases.getCaseType(), caseTypeDto);
        caseDto.setCaseType(caseTypeDto);
        return caseDto;
    }
}