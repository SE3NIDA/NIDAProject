package com.java.stock.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.User;
import com.java.stock.model.entity.Warehouse;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@SuppressWarnings("deprecation")
	@Override
	public User validateUserLogin(String strUserName, String password)
			throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		User obj = null;

		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Expression.eq("usName", strUserName));
		criteria.add(Expression.eq("usPass", password));
		// criteria.add(Expression.eq("usState", "ACT"));

		@SuppressWarnings("rawtypes")
		List objs = getHibernateTemplate().findByCriteria(criteria);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (User) objs.get(0);
		}

		return obj;
	}

	@Override
	public List<User> searchEmployee() throws DataAccessException,
			SQLException {

		List<User> objs = null;
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Criteria crit = session.createCriteria(User.class);
		List results = crit.list();
		Iterator itr = results.iterator();
		objs = new ArrayList<User>();
		while (itr.hasNext()) {
			User wah = (User) itr.next();
			objs.add(wah);
		}

		return objs;
	}

	@Override
	public List<User> searchEmployee(long id, String name)
			throws DataAccessException, SQLException {
		return null;
	}

	@Override
	public void addnewUser(User user) throws DataAccessException, SQLException {
		getHibernateTemplate().save(user);
	}

}
