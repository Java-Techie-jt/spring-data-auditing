package com.javatechie.spring.auditing.api.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.auditing.api.dao.EmployeeRepository;
import com.javatechie.spring.auditing.api.dto.InputRequest;
import com.javatechie.spring.auditing.api.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public String saveEmployee(InputRequest<Employee> request) {
		String currentUser = request.getLoggedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		Employee employee = request.getEmployee();
		employee.setCreatedBy(currentUser);
		repository.save(employee);
		return "Employee saved successfully...";

	}

	public String updateEmployee(int id, double salary, InputRequest<Employee> request) {
		Employee employee = repository.findById(id).get();
		if (employee != null) {
			employee.setSalary(salary);
			employee.setModifiedBy(request.getLoggedInUser());
			repository.saveAndFlush(employee);
		} else {
			throw new RuntimeException("Employee not found with id : " + id);
		}
		return "Employee Updated successfully ";
	}

}
