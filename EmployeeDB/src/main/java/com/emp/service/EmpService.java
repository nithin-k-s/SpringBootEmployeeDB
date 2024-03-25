package com.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;
import com.emp.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	EmpRepo emprepo;
	
	public EmpService(EmpRepo emprepo) {
		this.emprepo = emprepo;
	}
	
	//All
	public List<Employee> getAllEmployee(){
		return emprepo.findAll();		
	}
	
	//one by id
	public Optional<Employee> getById(int id) {
		return emprepo.findById(id);
	}
	
	
	//save
	public Employee save(Employee emp) {
		return emprepo.save(emp);
	}
	
	//deleteById
	public void deleteById(int id) {
		emprepo.deleteById(id);
	}
	
	
	//getFiltered Employee address and age
	public List<Employee> getFilteredEmployee(Employee inpFilteredEmp){
		
		List<Employee> RepoEmp = emprepo.findAll();
		List<Employee> FilteredEmp = new ArrayList<>();
		
		for(Employee emp : RepoEmp) {
			if(emp.getAddress().equalsIgnoreCase(inpFilteredEmp.getAddress()) &&
					emp.getAge()==inpFilteredEmp.getAge()) {
				FilteredEmp.add(emp);
			}
		}
		
		return FilteredEmp;
	}
	
	
}
