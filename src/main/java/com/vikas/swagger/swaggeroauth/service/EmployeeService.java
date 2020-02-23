package com.vikas.swagger.swaggeroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.vikas.swagger.swaggeroauth.entity.Employee;
import com.vikas.swagger.swaggeroauth.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	public Employee addEmployee(Employee emp) {
		
		Employee empSaved = empRepo.save(emp);
		
		return empSaved;
	}
}
