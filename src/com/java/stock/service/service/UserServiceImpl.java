package com.java.stock.service.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.java.stock.common.util.ServiceFinder;
import com.java.stock.model.dao.EmployeeDao;
import com.java.stock.model.dao.UserDao;
import com.java.stock.model.entity.User;

public class UserServiceImpl implements UserService {

	private EmployeeDao empDao =(EmployeeDao)ServiceFinder.findBean("employeeSpringDAO");  
	private UserDao dao =(UserDao)ServiceFinder.findBean("usersSpringDAO"); 
	
	@Override
	public User validateUserLogin(String strUserName, String password)
			throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		return dao.validateUserLogin(strUserName, password);
	}

	@Override
	public List<User> searchEmployee() throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		return dao.searchEmployee();
	}

	@Override
	public List<User> searchEmployee(long id, String name)
			throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		return dao.searchEmployee(id, name);
	}

	@Override
	public void addnewUser(User user) throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		dao.addnewUser(user);
	}


}
