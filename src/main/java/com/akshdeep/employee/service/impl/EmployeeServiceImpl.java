package com.akshdeep.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akshdeep.employee.entity.Employee;
import com.akshdeep.employee.repository.EmployeeJpaRepo;
//import com.akshdeep.employee.repository.EmployeeRepo;
import com.akshdeep.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeJpaRepo employeeJparepo;

	//@Autowired
	//private EmployeeRepo employeerepo;

	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = employeeJparepo.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id :" + id);
		}
		return employee;
	}

	public List<Employee> getEmployeeByEmail(String email) {
		List<Employee> emp = employeeJparepo.getEmployeeByEmail(email);
		return emp;
	}
	
	public List<Employee> getAllEmployee() {
		List<Employee> emp = employeeJparepo.findAll();
		return emp;
	}
	
	public Employee saveEmployee(Employee emp) {
		Employee empRes = employeeJparepo.save(emp);
		return empRes;
	}
	
	public void deleteEmployee(int empId) {
		employeeJparepo.deleteById(empId);
		System.out.println("After delete");
	}
	
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> optional=employeeJparepo.findById(emp.getID());
		Employee employee=optional.get();
		employee.setAge(emp.getAge());
		employee.setEmail(emp.getEmail());
		employee.setName(emp.getName());
		Employee savedEmployee=employeeJparepo.save(employee);
		return savedEmployee;
	}

}
