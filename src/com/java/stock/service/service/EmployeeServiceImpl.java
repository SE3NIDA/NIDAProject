package com.java.stock.service.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.common.util.ServiceFinder;
import com.java.stock.model.dao.EmployeeDao;
import com.java.stock.model.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao empDao =(EmployeeDao)ServiceFinder.findBean("employeeSpringDAO");  

	@Override
	public void addnewEmp(Employee employee) throws DataAccessException,
			SQLException {
    		empDao.addnewEmp(employee);
	}

	@Override
	public List<Employee> searchEmployee() throws DataAccessException,
			SQLException {
		return empDao.searchEmployee();
	}

	@Override
	public List<Employee> searchEmployee(long id, String name)
			throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		return empDao.searchEmployee(id, name);
	}

}
