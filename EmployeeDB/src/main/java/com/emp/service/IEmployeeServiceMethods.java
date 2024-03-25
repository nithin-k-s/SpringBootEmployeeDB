package com.emp.service;

import java.util.List;
import java.util.Optional;

import com.emp.model.Employee;

public interface IEmployeeServiceMethods {

	List<Employee> getAllEmployee();
	Optional<Employee> getById(int id);
	Employee save(Employee emp);
	void deleteByID(int id);
	List<Employee> getFilteredEmployee(Employee inpFilteredEmp);
	
	
}
