package com.java.stock.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.control.action.SuppliersAction;
import com.java.stock.model.entity.Customer;
import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.Supplier;
import com.java.stock.model.entity.Warehouse;



public interface SuppliersDao {
	
	public void addnewSup(Supplier sup) throws DataAccessException,java.sql.SQLException;
	public List<Supplier>  searchSuppliers() throws DataAccessException,SQLException;
	
	public List<Supplier>  searchSuppliers(long id, String name) throws DataAccessException,SQLException;
	
	public Supplier searchSuppliersByID(long id) throws DataAccessException,SQLException;
	
	
	
}
