package com.java.stock.service.service;

import org.springframework.dao.DataAccessException;

import com.java.stock.model.entity.Employee;

public interface EmployeeService {
	
	public void addnewEmp(Employee employee) throws DataAccessException,java.sql.SQLException;

}
