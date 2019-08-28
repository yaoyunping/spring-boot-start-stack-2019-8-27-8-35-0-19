package com.tw.apistackbase.controller;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.Employee;




@RestController
@RequestMapping("/employee")
public class employeeController {
	private static List<Employee>employees = new ArrayList<Employee>() {{
		add(new Employee(1,"xiaoming",20,"male"));
		add(new Employee(2,"xiaohu",12,"male"));
		add(new Employee(3,"xiaoliu",18,"famale"));
	}};
	
	@GetMapping
	 public ResponseEntity<List<Employee>> getEmployees(@RequestParam("name") String namelike){
	  List<Employee> employees = new ArrayList<Employee>();
	  List<Employee> employeesRtn = new ArrayList<Employee>();
	  Employee employee1 = new Employee();
	  employee1.setId(1);
	  employee1.setAge(20);
	  employee1.setGender("male");
	  employee1.setName("xiaoming");
	  
	  Employee employee2 = new Employee();
	  employee2.setId(2);
	  employee2.setAge(12);
	  employee2.setGender("male");
	  employee2.setName("xiaohu");
	  
	  Employee employee3 = new Employee();
	  employee3.setAge(18);
	  employee3.setGender("female");
	  employee3.setId(3);
	  employee3.setName("xiaoliu");
	  
	  employees.add(employee1);
	  employees.add(employee2);
	  employees.add(employee3);
	  
	  for (Employee employee : employees) {
		   if(employee.getName().contains(namelike)) {
			   employeesRtn.add(employee);
		   }
		  }
	  return ResponseEntity.ok(employeesRtn);	  
	}
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		employees.add(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
	
	
	
//	 @GetMapping("/{id}")
//	 public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
//	  List<Employee> employees = new ArrayList<Employee>();
//	  Employee employee1 = new Employee();
//	  employee1.setId(222);
//	  employee1.setAge(20);
//	  employee1.setGender("male");
//	  employee1.setName("xiaoming");
//	  
//	  Employee employee2 = new Employee();
//	  employee2.setId(2);
//	  employee2.setAge(12);
//	  employee2.setGender("male");
//	  employee2.setName("xiaohu");
//	  
//	  Employee employee3 = new Employee();
//	  employee3.setAge(18);
//	  employee3.setGender("female");
//	  employee3.setId(22);
//	  employee3.setName("xiaoliu");
//	  
//	  employees.add(employee1);
//	  employees.add(employee2);
//	  employees.add(employee3);
//	  for (Employee employee : employees) {
//	   if(employee.getId()==id) {
//	    return ResponseEntity.ok(employee);
//	   }
//	  }
//	  return null;
//	 }


