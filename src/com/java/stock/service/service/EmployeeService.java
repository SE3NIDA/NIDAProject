package com.java.stock.service.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.model.entity.Employee;

public interface EmployeeService {
	
	public void addnewEmp(Employee employee) throws DataAccessException,java.sql.SQLException;
	
	public List<Employee>  searchEmployee() throws DataAccessException,SQLException;
	
	public List<Employee>  searchEmployee(long id, String name) throws DataAccessException,SQLException;

}
