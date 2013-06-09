package com.java.stock.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.model.entity.Customer;
import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.Warehouse;



public interface EmployeeDao {
	
	public void addnewEmp(Employee employee) throws DataAccessException,java.sql.SQLException;
	public List<Employee>  searchEmployee() throws DataAccessException,SQLException;
	
	public List<Employee>  searchEmployee(long id, String name) throws DataAccessException,SQLException;
	
	public Employee  searchEmployeeByID(long id) throws DataAccessException,SQLException;
	
}
