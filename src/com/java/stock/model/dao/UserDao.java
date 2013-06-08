package com.java.stock.model.dao;


import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.User;
import com.java.stock.model.entity.Warehouse;

public interface UserDao {
	
	public User validateUserLogin(String strUserName,String password) throws DataAccessException,java.sql.SQLException;
	public List<User>  searchEmployee() throws DataAccessException,SQLException;
	public List<User>  searchEmployee(long id, String name) throws DataAccessException,SQLException;
	public void addnewUser(User user) throws DataAccessException,SQLException;
}
