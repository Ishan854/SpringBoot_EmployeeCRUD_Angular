package com.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringProject.DTO.EmployeeDTO;
import com.SpringProject.DTO.EmployeeSaveDTO;
import com.SpringProject.DTO.EmployeeUpdateDTO;
import com.SpringProject.Service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/save")
	public String saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO) {
		String id = employeeService.addEmployee(employeeSaveDTO);
		return id;
	}
	
	@GetMapping("/getAllEmployee")
	public List<EmployeeDTO> getAllEmployee(){
		
		List<EmployeeDTO> allEmployees = employeeService.getAllEmployee();
		return allEmployees;
	}

	@PutMapping("/update")
	public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
		String id = employeeService.updateEmployee(employeeUpdateDTO);
		return id;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value="id")int id) {
		boolean deleteEmployee = employeeService.deleteEmployee(id);
		return "Deleted Successfully";
	}
}
