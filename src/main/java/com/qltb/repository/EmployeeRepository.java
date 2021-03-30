package com.qltb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qltb.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
