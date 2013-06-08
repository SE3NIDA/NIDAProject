package com.java.stock.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.java.stock.model.entity.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public void addnewEmp(Employee employee) throws DataAccessException,
			SQLException {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().saveOrUpdate(employee);

	}

	@Override
	public List<Employee> searchEmployee() throws DataAccessException,
			SQLException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		List<Employee> objs = null;
		
		Criteria crit = session.createCriteria(Employee.class);
		List results = crit.list();
		Iterator itr = results.iterator();
		objs = new ArrayList<Employee>();
		  while(itr.hasNext()){
			  Employee wah = (Employee) itr.next();
			objs.add(wah);
		  }
		
		return objs;
		
	}

	@Override
	public List<Employee> searchEmployee(long id, String name)
			throws DataAccessException, SQLException {
		List<Employee> objs = null;
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		if(id != 0)
			criteria.add(Expression.idEq(id));	
		if(null != name)
			criteria.add(Expression.like("empFname", name , MatchMode.ANYWHERE).ignoreCase());
		
		List results = getHibernateTemplate().findByCriteria(criteria);
		
		Iterator itr = results.iterator();
		objs = new ArrayList<Employee>();
		  while(itr.hasNext()){
			  Employee wah = (Employee) itr.next();
			objs.add(wah);
		  }
		
		return objs;
	}

	@Override
	public Employee searchEmployeeByID(long id)
			throws DataAccessException, SQLException {
		
		Employee wah = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		if(id != 0)
			criteria.add(Expression.idEq(id));	
		
		List results = getHibernateTemplate().findByCriteria(criteria);
		
		Iterator itr = results.iterator();
		  while(itr.hasNext()){
			   wah = (Employee) itr.next();
		  }
		
		return wah;
	}

}
