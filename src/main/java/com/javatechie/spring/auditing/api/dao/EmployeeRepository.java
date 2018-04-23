package com.javatechie.spring.auditing.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.auditing.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
