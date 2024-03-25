package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer> {

}
