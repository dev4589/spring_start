package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController
{
	@Autowired
	EmployeeService				employeeService;

	@PostConstruct
	private void postConstruct()
	{
		Employee employee = new Employee("devansh", 25, "devparmar@gmail.com");
		employeeService.saveOrUpdate(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id)
	{
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id)
	{
		employeeService.deleteEmployeeById(id);
	}

	@PostMapping(value = "/employee", consumes = { "application/json" })
	public void addEmployee(@RequestBody Employee employee)
	{
		employeeService.saveOrUpdate(employee);
	}

	@PutMapping("/employee")
	public void updateEmployee(@RequestBody Employee employee)
	{
		employeeService.saveOrUpdate(employee);
	}
}