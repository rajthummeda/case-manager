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

import com.mastercard.sanctions.casemanager.dto.CustomerTypeDto;
import com.mastercard.sanctions.casemanager.entities.CustomerType;
import com.mastercard.sanctions.casemanager.service.CustomerTypeService;

@RestController
@RequestMapping("/api/customer-type")
public class CustomerTypeController {

	@Autowired
    private CustomerTypeService customerTypeService;

    @PostMapping
    public ResponseEntity<CustomerType> createCustomerType(@RequestBody CustomerTypeDto customerTypeDto) {
        CustomerType createdCustomerType = customerTypeService.createCustomerType(customerTypeDto);
        return new ResponseEntity<>(createdCustomerType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerType> updateCustomerType(@PathVariable Long id, @RequestBody CustomerTypeDto customerTypeDto) {
        CustomerType updatedCustomerType = customerTypeService.updateCustomerType(id, customerTypeDto);
        return new ResponseEntity<>(updatedCustomerType, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerType> getCustomerTypeById(@PathVariable Long id) {
        CustomerType customerType = customerTypeService.getCustomerTypeById(id);
        return new ResponseEntity<>(customerType, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerType>> getAllCustomerTypes() {
        List<CustomerType> customerTypes = customerTypeService.getAllCustomerTypes();
        return new ResponseEntity<>(customerTypes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerType(@PathVariable Long id) {
        customerTypeService.deleteCustomerType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
