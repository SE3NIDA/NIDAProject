package com.java.stock.service.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.common.util.ServiceFinder;
import com.java.stock.model.dao.WarehouseDao;
import com.java.stock.model.entity.Warehouse;

public class WareHouseServiceImpl implements WareHouseService {

	private WarehouseDao warDao =(WarehouseDao)ServiceFinder.findBean("wharehouseSpringDAO");  
	@Override
	public void addnewWharehouse(Warehouse employee)
			throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		warDao.addnewWharehouse(employee);
	}

	@Override
	public long maxWharehouseId() throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		return warDao.maxWharehouseId();
	}

	@Override
	public List<Warehouse> searchWherehouse() throws DataAccessException,
			SQLException {
		// TODO Auto-generated method stub
		return warDao.searchWherehouse();
	}

	@Override
	public List<Warehouse> searchWherehouse(long id, String name)
			throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		return warDao.searchWherehouse(id, name);
	}

	
}
