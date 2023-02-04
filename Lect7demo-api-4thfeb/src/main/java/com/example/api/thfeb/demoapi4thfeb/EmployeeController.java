package com.example.api.thfeb.demoapi4thfeb;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	//singleton -- means only one objects of this class can be created
	//prototype -- means multiples of this type can created
	
	/* create api for employee management
	 * 1) add the employee details --> INPUT: employee object, output: void
	 * 2) update the employee details --> input: employee detail to be updated, output: employee object 
	 * 3) delete the employee details --->input : employee id , output : boolean| employee| void
	 * 4) get the employee details ------> input : employee id , output : employee object
	 * */
	
	public static int count =1;
	
	HashMap<Integer,Employee> employeeMap = new HashMap<>();
	
	
	@PostMapping("/employee/add")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		
	System.out.println(this);
		
	employee.setId(count++);
		employeeMap.put(employee.getId(), employee);
		return employee;
	}
	
	@GetMapping("/employee/get")
	public Employee getEmployee(@RequestParam("id") int id) {
		System.out.println(this);
		return employeeMap.get(id);
	}
	
	@PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
		System.out.println(this);
		if(employee.getId() == null) {
			throw new Exception("id is not present for the employee to be updated ");
		}
		
		if(!employeeMap.containsKey(employee.getId())) {
			throw new Exception("Employee is not present");
		}
		
		
		
		employeeMap.put(employee.getId(), employee);
		return employee;
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public Employee deleteEmployee(@PathVariable("id")int id) {
		System.out.println(this);
		return employeeMap.remove(id);
	}
	
	@GetMapping("/employee/get/all")
	public  List<Employee >getEmployee() {
		System.out.println(this);
		return employeeMap.values().stream().collect(Collectors.toList());
		
	}
	
	
	
	@GetMapping("/getValue")
	public Integer getListOfNumbers() {
		return null;
		
	}
	
	
	
	
}
