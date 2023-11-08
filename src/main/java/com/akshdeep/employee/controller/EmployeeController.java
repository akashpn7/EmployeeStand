package com.akshdeep.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.akshdeep.employee.entity.Employee;
import com.akshdeep.employee.service.EmployeeService;

@RestController
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/getAll")
	private List<Employee> getAllEmployee(){
		List<Employee> emps=employeeService.getAllEmployee();
		return emps;
	}
	
	@GetMapping("/employee/{id}")
	private ResponseEntity<Employee> getEmployeeDetails(@PathVariable("id") int id){
		Employee employee=employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@GetMapping("/employee/byemail/{email}")
	private ResponseEntity<List<Employee>> getEmployeeData(@PathVariable("email") String email){
		List<Employee> employee=employeeService.getEmployeeByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@PostMapping("/employee/save")
	private Employee saveEmployee(@RequestBody Employee data) {
		return employeeService.saveEmployee(data);
	}
	
	@DeleteMapping("/employee/delete/{empId}")
	private void deleteEmployee(@PathVariable("empId") int id) {
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/employee/update")
	private Employee updateEmployee(@RequestBody Employee emp){
		return employeeService.updateEmployee(emp);
	}
	
}
