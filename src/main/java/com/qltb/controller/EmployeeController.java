package com.qltb.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.qltb.entity.Employee;
import com.qltb.service.EmployeeService;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployee()
	{
		return employeeService.getAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee retrieveEmployee(@PathVariable long id) {
		Optional<Employee> employee = employeeService.findById(id);
		return employee.get();
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteById(id);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.save(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

		Optional<Employee> employeeOptional = employeeService.findById(id);

		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();

		employee.setId(id);
		
		employeeService.save(employee);

		return ResponseEntity.noContent().build();
	}
}
