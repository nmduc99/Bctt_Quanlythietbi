package com.qltb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qltb.entity.Employee;
import com.qltb.repository.EmployeeRepository;
import com.qltb.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	public EmployeeRepository employeeRepo;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo ) {
		super();
		this.employeeRepo= employeeRepo;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}
	
	@Override
	public Optional<Employee> findById(Long id) {
		return employeeRepo.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
	}
	
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}
	
}
