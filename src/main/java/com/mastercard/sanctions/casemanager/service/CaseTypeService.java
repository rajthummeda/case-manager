package com.mastercard.sanctions.casemanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.sanctions.casemanager.dto.CaseTypeDto;
import com.mastercard.sanctions.casemanager.entities.CaseType;
import com.mastercard.sanctions.casemanager.repository.CaseTypeRepository;

@Service
public class CaseTypeService {

	@Autowired
	private CaseTypeRepository caseTypeRepository;

	public CaseTypeDto saveCaseType(CaseTypeDto caseTypeDto) {
		// Convert CaseTypeDto to CaseType entity
		CaseType caseType = new CaseType();
		caseType.setType(caseTypeDto.getType());

		// Save the CaseType entity using the repository
		CaseType savedCaseType = caseTypeRepository.save(caseType);
		return CaseTypeDto.builder().id(savedCaseType.getCaseTypeId()).type(savedCaseType.getType()).build();
	}

	public CaseTypeDto updateCaseType(Long id, CaseTypeDto caseTypeDto) {
		Optional<CaseType> optionalCaseType = caseTypeRepository.findById(id);
		if (optionalCaseType.isPresent()) {
			CaseType existingCaseType = optionalCaseType.get();
			existingCaseType.setType(caseTypeDto.getType());
			CaseType updatedCaseType = caseTypeRepository.save(existingCaseType);
			return new CaseTypeDto(updatedCaseType.getCaseTypeId(), updatedCaseType.getType());
		} else {
			throw new IllegalArgumentException("CaseType not found with ID: " + id);
		}
	}

	public CaseTypeDto getCaseTypeById(Long id) {
		Optional<CaseType> optionalCaseType = caseTypeRepository.findById(id);
		if (optionalCaseType.isPresent()) {
			CaseType caseType = optionalCaseType.get();
			CaseTypeDto caseTypeDto = new CaseTypeDto();
			caseTypeDto.setId(caseType.getCaseTypeId());
			caseTypeDto.setType(caseType.getType());
			return caseTypeDto;
		} else {
			throw new IllegalArgumentException("CaseType not found with ID: " + id);
		}
	}

	public List<CaseTypeDto> getAllCaseTypes() {
		List<CaseTypeDto> caseTypeDtoList = new ArrayList<>();
		List<CaseType> caseTypeList = caseTypeRepository.findAll();
		for (CaseType caseType : caseTypeList) {
			CaseTypeDto caseTypeDto = new CaseTypeDto();
			caseTypeDto.setId(caseType.getCaseTypeId());
			caseTypeDto.setType(caseType.getType());
			caseTypeDtoList.add(caseTypeDto);
		}
		return caseTypeDtoList;
	}

	public void deleteCaseType(Long id) {
		Optional<CaseType> optionalCaseType = caseTypeRepository.findById(id);
		if (optionalCaseType.isPresent()) {
			caseTypeRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("CaseType not found with ID: " + id);
		}
	}

}