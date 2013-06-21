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

import com.java.stock.control.action.SuppliersAction;
import com.java.stock.model.entity.Customer;
import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.Supplier;

public  class SuppliersDaoImpl extends HibernateDaoSupport implements SuppliersDao {

	public void addnewSup(Supplier suppliers) throws DataAccessException,
			SQLException {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().saveOrUpdate(suppliers);

	}

	@Override
	public List<Supplier> searchSuppliers() throws DataAccessException,
			SQLException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		List<Supplier> objs = null;
		
		Criteria crit = session.createCriteria(Supplier.class);
		List results = crit.list();
		Iterator itr = results.iterator();
		objs = new ArrayList<Supplier>();
		  while(itr.hasNext()){
			  Supplier wah = (Supplier) itr.next();
			objs.add(wah);
		  }
		
		return objs;
		
	}

	@Override
	public List<Supplier> searchSuppliers(long id, String name)
			throws DataAccessException, SQLException {
		List<Supplier> objs = null;
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Supplier.class);
		if(id != 0)
			criteria.add(Expression.idEq(id));	
		if(null != name)
			criteria.add(Expression.like("supFname", name , MatchMode.ANYWHERE).ignoreCase());
		
		List results = getHibernateTemplate().findByCriteria(criteria);
		
		Iterator itr = results.iterator();
		objs = new ArrayList<Supplier>();
		  while(itr.hasNext()){
			  Supplier wah = (Supplier) itr.next();
			objs.add(wah);
		  }
		
		return objs;
	}

	public Supplier searchSuppliersByID1(long id)
			throws DataAccessException, SQLException {
		
		Supplier wah = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if(id != 0)
			criteria.add(Expression.idEq(id));	
		
		List results = getHibernateTemplate().findByCriteria(criteria);
		
		Iterator itr = results.iterator();
		  while(itr.hasNext()){
			   wah = (Supplier) itr.next();
		  }
		
		return wah;
	}

	@Override
	public Supplier searchSuppliersByID(long id) throws DataAccessException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
