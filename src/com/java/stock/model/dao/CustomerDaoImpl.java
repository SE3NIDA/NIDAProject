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

import com.java.stock.model.entity.Customer;
import com.java.stock.model.entity.Employee;

public  class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void addnewCus(Customer customer) throws DataAccessException,
			SQLException {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().saveOrUpdate(customer);

	}

	@Override
	public List<Customer> searchCustomer() throws DataAccessException,
			SQLException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		List<Customer> objs = null;
		
		Criteria crit = session.createCriteria(Customer.class);
		List results = crit.list();
		Iterator itr = results.iterator();
		objs = new ArrayList<Customer>();
		  while(itr.hasNext()){
			  Customer wah = (Customer) itr.next();
			objs.add(wah);
		  }
		
		return objs;
		
	}

	@Override
	public List<Customer> searchCustomer(long id, String name)
			throws DataAccessException, SQLException {
		List<Customer> objs = null;
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if(id != 0)
			criteria.add(Expression.idEq(id));	
		if(null != name)
			criteria.add(Expression.like("cusFname", name , MatchMode.ANYWHERE).ignoreCase());
		
		List results = getHibernateTemplate().findByCriteria(criteria);
		
		Iterator itr = results.iterator();
		objs = new ArrayList<Customer>();
		  while(itr.hasNext()){
			  Customer wah = (Customer) itr.next();
			objs.add(wah);
		  }
		
		return objs;
	}

	@Override
	public Customer searchCustomerByID(long id)
			throws DataAccessException, SQLException {
		
		Customer wah = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if(id != 0)
			criteria.add(Expression.idEq(id));	
		
		List results = getHibernateTemplate().findByCriteria(criteria);
		
		Iterator itr = results.iterator();
		  while(itr.hasNext()){
			   wah = (Customer) itr.next();
		  }
		
		return wah;
	}

}
