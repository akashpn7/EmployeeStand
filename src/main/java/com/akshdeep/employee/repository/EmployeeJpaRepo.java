package com.akshdeep.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshdeep.employee.entity.Employee;

public interface EmployeeJpaRepo extends JpaRepository<Employee,Integer> {
	public List<Employee> getEmployeeByEmail(String email);
}
