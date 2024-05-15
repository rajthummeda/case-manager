package com.mastercard.sanctions.casemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.sanctions.casemanager.dto.CustomerTypeDto;
import com.mastercard.sanctions.casemanager.entities.CustomerType;
import com.mastercard.sanctions.casemanager.repository.CustomerTypeRepository;

@Service
public class CustomerTypeService {

	@Autowired
	private CustomerTypeRepository customerTypeRepository;

	public CustomerType createCustomerType(CustomerTypeDto customerTypeDto) {
		CustomerType customerType = new CustomerType();
		customerType.setType(customerTypeDto.getType());
		return customerTypeRepository.save(customerType);
	}

	public CustomerType updateCustomerType(Long id, CustomerTypeDto customerTypeDto) {
		CustomerType customerType = customerTypeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Customer type not found"));
		customerType.setType(customerTypeDto.getType());
		return customerTypeRepository.save(customerType);
	}

	public CustomerType getCustomerTypeById(Long id) {
		return customerTypeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Customer type not found"));
	}

	public List<CustomerType> getAllCustomerTypes() {
		return customerTypeRepository.findAll();
	}

	public void deleteCustomerType(Long id) {
		customerTypeRepository.deleteById(id);
	}
}