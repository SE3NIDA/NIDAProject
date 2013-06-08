package com.java.stock.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.model.entity.Warehouse;

public interface WarehouseDao {
	
	public void addnewWharehouse(Warehouse employee) throws DataAccessException,SQLException;
	
	public long maxWharehouseId() throws DataAccessException,SQLException;
	
	public List<Warehouse>  searchWherehouse() throws DataAccessException,SQLException;
	
	public List<Warehouse>  searchWherehouse(long id, String name) throws DataAccessException,SQLException;

}
