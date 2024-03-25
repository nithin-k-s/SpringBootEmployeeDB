package com.emp.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.Exception.EmployeeNotFoundException;
import com.emp.model.Employee;
import com.emp.service.EmpService;

@RestController
@RequestMapping("/sapi")
public class EmpController {

	@Autowired
	EmpService empservice;
	
	public EmpController(EmpService empservice) {
		this.empservice=empservice;
	}
	
	
	//getAllEmployees
	@GetMapping("/Employees")
	public List<Employee> getAllEmployees(){
		
		return this.empservice.getAllEmployee();		
	}
	
	
	//getById
	@GetMapping("/Employee/{id}")
	public Employee findById(@PathVariable("id") @Min(1) int id) {
		Employee emp = this.empservice.getById(id).orElseThrow(()->new EmployeeNotFoundException("Employee "+id+"Not Found!"));
		return emp;
	}
	
	
	//insert employee post
	@PostMapping("/Employee")
	public Employee addEmployee(@Valid @RequestBody Employee emp)
	{
		return this.empservice.save(emp);
	}
	
	
	//update put
	@PutMapping("/Employee/{id}")
	public Employee updateEmployee(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Employee newemp) {
		Employee emp1 = this.empservice.getById(id).orElseThrow(()->new EmployeeNotFoundException("Employee "+id+" Not Found!"));
		
		
		emp1.setName(newemp.getName());
		emp1.setAge(newemp.getAge());
		emp1.setAddress(newemp.getAddress());
		
		return this.empservice.save(emp1);	
	}
	
	//filtered employee
	@GetMapping("/filter")
	public List<Employee> getFilteredEmployees(){
		Employee inpFilterEmpl = new Employee();
		inpFilterEmpl.setAddress("Mysore");
		inpFilterEmpl.setAge(24);
		inpFilterEmpl.setName("Adzxc");
		
		List<Employee> filteredEmployeeList = this.empservice.getFilteredEmployee(inpFilterEmpl);
		
		return filteredEmployeeList;
		
	}
}
