package com.java.stock.service.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.model.entity.User;

public interface UserService {
	
	public User validateUserLogin(String strUserName,String password) throws DataAccessException,java.sql.SQLException;
	public List<User>  searchEmployee() throws DataAccessException,SQLException;
	public List<User>  searchEmployee(long id, String name) throws DataAccessException,SQLException;
	public void addnewUser(User user) throws DataAccessException,SQLException;

}
