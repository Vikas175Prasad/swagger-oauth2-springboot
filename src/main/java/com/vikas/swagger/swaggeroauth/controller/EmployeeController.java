package com.vikas.swagger.swaggeroauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vikas.swagger.swaggeroauth.entity.Employee;
import com.vikas.swagger.swaggeroauth.service.EmployeeService;

@Controller
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> getString(){
		
		
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
		 
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		
		ResponseEntity<Employee> resp= null;
		Employee e= empService.addEmployee(emp);
		
		resp = new ResponseEntity<Employee>(e, HttpStatus.OK);
		return resp;
	}
}
