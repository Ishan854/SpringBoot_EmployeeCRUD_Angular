package com.SpringProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringProject.DTO.EmployeeDTO;
import com.SpringProject.DTO.EmployeeSaveDTO;
import com.SpringProject.DTO.EmployeeUpdateDTO;
import com.SpringProject.Entity.Employee;
import com.SpringProject.Repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {
		Employee employee = new Employee(
				employeeSaveDTO.getEmployeename(),
				employeeSaveDTO.getEmployeeaddress(),
				employeeSaveDTO.getMobile()
				);
		employeeRepo.save(employee);
				
		return employee.getEmployeename();
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee>getEmployees = employeeRepo.findAll();
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		for(Employee e : getEmployees) {
			EmployeeDTO employeeDTO = new EmployeeDTO(
					e.getEmployeeid(),
					e.getEmployeename(),
					e.getEmployeeaddress(),
					e.getMobile()
					);
			employeeDTOList.add(employeeDTO);
		}
		return employeeDTOList;
	}

	@Override
	public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
		// TODO Auto-generated method stub
		if(employeeRepo.existsById(employeeUpdateDTO.getEmployeeid())) {
			Employee employee = employeeRepo.getById(employeeUpdateDTO.getEmployeeid());
			employee.setEmployeename(employeeUpdateDTO.getEmployeename());
			employee.setEmployeeaddress(employeeUpdateDTO.getEmployeeaddress());
			employee.setMobile(employeeUpdateDTO.getMobile());
			
			employeeRepo.save(employee);
		}else {
			System.out.println("Employee ID Not Found");
		}
		
		return null;
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
		}else {
			System.out.println("Employee Id Not Found");
		}
		return true;
	}
	
}
