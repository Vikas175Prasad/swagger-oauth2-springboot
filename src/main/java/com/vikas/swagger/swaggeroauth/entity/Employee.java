package com.vikas.swagger.swaggeroauth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_loc")
	private String empLoc;
	
	@Column(name="emp_email")
	private String empEmail;
	
	@Column(name="emp_phone")
	private String empPhone;

	public Employee(String empName, String empLoc, String empEmail, String empPhone) {
		super();
		this.empName = empName;
		this.empLoc = empLoc;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLoc() {
		return empLoc;
	}

	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	
	
	
}
