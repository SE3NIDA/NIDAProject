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
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.java.stock.model.entity.User;
import com.java.stock.model.entity.Warehouse;

public class WarehouseDaoImpl extends HibernateDaoSupport implements WarehouseDao {

	
	 
	@Override
	public void addnewWharehouse(Warehouse employee)
			throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(employee);
	}

	@Override
	public long maxWharehouseId() throws DataAccessException, SQLException {
		
		 Session session = getHibernateTemplate().getSessionFactory().openSession();
		 
		long obj = new Long(0);
		
		 Criteria crit = session.createCriteria(Warehouse.class);
         ProjectionList prolist = Projections.projectionList();
         prolist.add(Projections.max("waId"));
         crit.setProjection(prolist);
         List list = crit.list();
         Iterator itr = list.iterator();
         
         if(itr.hasNext()){
        	 obj =  new Long((Long) itr.next());
         }
		return obj;
	}

	@Override
	public List<Warehouse>  searchWherehouse() throws DataAccessException,
			SQLException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		List<Warehouse> objs = null;
		
		Criteria crit = session.createCriteria(Warehouse.class);
		List results = crit.list();
		Iterator itr = results.iterator();
		objs = new ArrayList<Warehouse>();
		  while(itr.hasNext()){
			Warehouse wah = (Warehouse) itr.next();
			objs.add(wah);
		  }
		
		return objs;
		
	}
	
	@Override
	public List<Warehouse>  searchWherehouse(long id, String name) throws DataAccessException,
			SQLException {
		
		List<Warehouse> objs = null;
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Warehouse.class);
		if(id != 0)
			criteria.add(Expression.idEq(id));	
		if(null != name)
			criteria.add(Expression.like("waName", name , MatchMode.ANYWHERE).ignoreCase());
		
		List results = getHibernateTemplate().findByCriteria(criteria);
		
		Iterator itr = results.iterator();
		objs = new ArrayList<Warehouse>();
		  while(itr.hasNext()){
			Warehouse wah = (Warehouse) itr.next();
			objs.add(wah);
		  }
		
		return objs;
		
	}

}
