package com.java.stock.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.model.entity.Customer;
import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.Warehouse;



public interface CustomerDao {
	
	public void addnewCus(Customer customer) throws DataAccessException,java.sql.SQLException;
	public List<Customer>  searchCustomer() throws DataAccessException,SQLException;
	
	public List<Customer>  searchCustomer(long id, String name) throws DataAccessException,SQLException;
	
	public Customer searchCustomerByID(long id) throws DataAccessException,SQLException;
}
