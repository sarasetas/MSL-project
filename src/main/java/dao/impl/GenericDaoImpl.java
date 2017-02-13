package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.GenericDao;

/**
 * Implements the GenericDao interface
 *
 * @param <T>
 * @param <PK>
 */
@SuppressWarnings("unchecked")
@Component
@Transactional	
public class GenericDaoImpl <T, PK extends Serializable> 
	extends HibernateDaoSupport implements GenericDao <T, PK> {
	
	/***********************
	 *   Class Variables   *
	 ***********************/
	
	/**
	 * Spring configured SessionFactory.
	 */
	
	private Class<T> type;
	
	/***********************
	 *    Class Methods    *
	 ***********************/
	
	/**
	 * The DAO constructor.
	 * @param type
	 */
	public GenericDaoImpl(Class<T> type) {
		this.setType(type);
	}
	
	@Override
	public void save(T object) {
		getHibernateTemplate().save(object);
	}

	@Override
	public void update(T object) {
		getHibernateTemplate().update(object);
	}

	@Override
	public void delete(T object) {
		getHibernateTemplate().delete(object);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria crit) {
		return findByCriteria(crit, -1, -1);
	}
	
	@Override
	public List<T> findByCriteria(DetachedCriteria crit, int firstResult, int maxResults) {
		return (List<T>) getHibernateTemplate().findByCriteria(crit, firstResult, maxResults);
	}

	@Override
	public List<T> findByExample(T example) {
		return (List<T>) getHibernateTemplate().findByExample(example);
	}

	@Override
	public T findById(PK id) {
		return (T) getHibernateTemplate().get(getType(), id);
	}

	@Override
	public Long count(DetachedCriteria crit) {
		return DataAccessUtils.longResult(getHibernateTemplate().findByCriteria(crit));
	}

	@Override
	public Session getCurrentSession() {
		return getSession();
	}
	
	@Override
	public List<Object> executeNamedQuery(String namedQuery, String[] args, Object[] values) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(namedQuery, args, values);
	}
	
	@Override
	public List<Object[]> executeNamedQueryMatrix(String namedQuery, String[] args, Object[] values) {
		
		return getHibernateTemplate().findByNamedQueryAndNamedParam(namedQuery, args, values);
	}
	
	
	/***********************
	 *  Getters & Setters  *
	 ***********************/
	
	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}
	



}	
