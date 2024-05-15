package com.mastercard.sanctions.casemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.sanctions.casemanager.dto.CaseTypeDetailsDto;
import com.mastercard.sanctions.casemanager.dto.CaseTypeDto;
import com.mastercard.sanctions.casemanager.dto.CaseTypeEnum;
import com.mastercard.sanctions.casemanager.dto.SaveCaseDto;
import com.mastercard.sanctions.casemanager.entities.CaseType;
import com.mastercard.sanctions.casemanager.entities.CaseTypeDetails;
import com.mastercard.sanctions.casemanager.entities.Cases;
import com.mastercard.sanctions.casemanager.entities.Type;
import com.mastercard.sanctions.casemanager.repository.CaseRepository;
import com.mastercard.sanctions.casemanager.repository.CaseTypeDetailsRepository;
import com.mastercard.sanctions.casemanager.repository.CaseTypeRepository;

@Service
public class CaseService {

	@Autowired
	private CaseRepository casesRepository;

	@Autowired
	private CaseTypeRepository caseTypeRepository;
	
	@Autowired
	private CaseTypeDetailsRepository caseTypeDetailsRepo;

	public Map<String, Object> createCase(SaveCaseDto caseDto) {
		Map<String, Object> response = new HashMap<>();
		Cases savedCase = null;
		if (Type.REGULAR.name().equalsIgnoreCase(caseDto.getTypeOfCase())) {
			savedCase = saveRegularCase(caseDto);
		} else if (Type.ADHOC.name().equalsIgnoreCase(caseDto.getTypeOfCase())) {
			savedCase = saveAdhocCase(caseDto);
		} else {
			throw new IllegalArgumentException("Invalid case type: " + caseDto.getTypeOfCase());
		}
		response.put("message", "Case created successfully of type : " + savedCase.getTypeOfCase());
		response.put("caseId", savedCase.getCaseId());
		return response;
	}

	
	private Cases saveRegularCase(SaveCaseDto caseDto) {
		String caseTypeData = caseDto.getCaseType();
		CaseType caseType = getCaseTypeIfExists(caseTypeData);
		 // Create Cases entity
        Cases cases = new Cases();
        BeanUtils.copyProperties(caseDto, cases);
        cases.setCaseType(caseType);
        return casesRepository.save(cases); // save case
	}
	
	private Cases saveAdhocCase(SaveCaseDto caseDto) {
		
		String caseTypeData = caseDto.getCaseType();
		CaseType caseType = getCaseTypeIfExists(caseTypeData);
		 // Create Cases entity
        Cases cases = new Cases();
        BeanUtils.copyProperties(caseDto, cases);
        cases.setCaseType(caseType);
        
        // Create CaseTypeDetails entity
 		CaseTypeDetails caseTypeDetails = new CaseTypeDetails();
 		CaseTypeDetailsDto caseDetailsDto = caseDto.getCaseTypeData();
 		BeanUtils.copyProperties(caseDetailsDto, caseTypeDetails);
 		
	    if(caseTypeData == CaseTypeEnum.INTERNAL_INQUIRY.getType()) {
	    	caseTypeDetails.setBusinessLine(caseDetailsDto.getBusinessLine());
	    } else if(caseTypeData == CaseTypeEnum.CUSTOMER_INQUIRY.getType()) {
	    	caseTypeDetails.setCustomerName(caseDetailsDto.getCustomerName());
	    	caseTypeDetails.setCustomerCId(caseDetailsDto.getCustomerCId());
	    } else if(caseTypeData == CaseTypeEnum.PRODUCT_REVIEW.getType()) {
	    	caseTypeDetails.setProductName(caseDetailsDto.getProductName());
	    } else if(caseTypeData == CaseTypeEnum.GOVERNMENT_REGULATOR.getType() ||
	    		caseTypeData == CaseTypeEnum.LAW_ENFORCEMENT.getType()) {
	    	caseTypeDetails.setAgencyName(caseDetailsDto.getAgencyName());
	    }
	    caseTypeDetails.setCaseType(caseType);
	    caseTypeDetailsRepo.save(caseTypeDetails); // save case type details
		return casesRepository.save(cases); // save case
	}

	private CaseType getCaseTypeIfExists(String caseType) {
        // Check if the case type exists in the database
        CaseType caseTypeEntity = caseTypeRepository.findByTypeIgnoreCase(caseType);
        if (caseTypeEntity == null) {
            throw new IllegalArgumentException("Case type does not exist: " + caseType);
        }
        return caseTypeEntity;
    }

	public SaveCaseDto getCaseById(String caseId) {
		Optional<Cases> optionalCases = casesRepository.findById(caseId);
		if (optionalCases.isPresent()) {
			Cases cases = optionalCases.get();
			SaveCaseDto caseDto = new SaveCaseDto();
			BeanUtils.copyProperties(cases, caseDto);
			// Set CaseTypeDto
			CaseTypeDto caseTypeDto = new CaseTypeDto();
			BeanUtils.copyProperties(cases.getCaseType(), caseTypeDto);
			caseDto.setCaseType(caseTypeDto.getType());
			return caseDto;
		}
		return null;
	}

	public List<SaveCaseDto> getCasesByType(String type) {
		List<Cases> casesList = casesRepository.findByTypeOfCase(type);
		return casesList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public List<SaveCaseDto> getAllCases() {
		List<Cases> casesList = casesRepository.findAll();
		return casesList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private SaveCaseDto convertToDto(Cases cases) {
		SaveCaseDto caseDto = new SaveCaseDto();
		BeanUtils.copyProperties(cases, caseDto);
		// Set CaseTypeDto
		CaseTypeDto caseTypeDto = new CaseTypeDto();
		BeanUtils.copyProperties(cases.getCaseType(), caseTypeDto);
		caseDto.setCaseType(caseTypeDto.getType());
		return caseDto;
	}
}