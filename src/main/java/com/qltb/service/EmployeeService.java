package com.qltb.service;

import java.util.List;
import java.util.Optional;

import com.qltb.entity.Employee;

public interface EmployeeService {

	List<Employee> getAll();

	Optional<Employee> findById(Long id);

	void deleteById(Long id);

	Employee save(Employee employee);

}
