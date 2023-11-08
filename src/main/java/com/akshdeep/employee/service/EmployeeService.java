package com.akshdeep.employee.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.akshdeep.employee.entity.Employee;

@Repository
public interface EmployeeService {

	public Employee getEmployeeById(int id);
	public List<Employee> getEmployeeByEmail(String email);
	public List<Employee> getAllEmployee();
	public Employee saveEmployee(Employee emp);
	public void deleteEmployee(int empId);
	public Employee updateEmployee(Employee emp);

}
