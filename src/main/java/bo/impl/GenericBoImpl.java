package bo.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

import bo.GenericBo;
import dao.GenericDao;	

/**
 * 
 * @author nturkman
 *
 * Implements the GenericBo interface
 *
 * @param <T>
 * @param <PK>
 */
public class GenericBoImpl <T, PK extends Serializable> implements GenericBo <T, PK> {

	/***********************
	 *   Class Variables   *
	 ***********************/

	private GenericDao<T, PK> dao;

	/***********************
	 *    Class Methods    *
	 ***********************/

	@Override
	public void save(T object) {

		//Properties of the current object
		PropertyAccessor newObjProps = PropertyAccessorFactory.forDirectFieldAccess(object);		

		Calendar cal11 = Calendar.getInstance();
		//now
		Date today = new Date(cal11.getTimeInMillis());

		if(newObjProps.getPropertyType("creationTimestamp") != null) 
		{
			newObjProps.setPropertyValue("creationTimestamp", today);
			newObjProps.setPropertyValue("lastUpdateTimestamp", today);
		}
		dao.save(object);	
	}

	@Override
	public void update(T object) {

		//Properties of the current object
		PropertyAccessor newObjProps = PropertyAccessorFactory.forDirectFieldAccess(object);		

		Calendar cal11 = Calendar.getInstance();
		//now
		Date today = new Date(cal11.getTimeInMillis());

		newObjProps.setPropertyValue("lastUpdateTimestamp", today);

		dao.update(object);	
	}

	@Override
	public void delete(T object) {
		dao.delete(object);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria crit) {
		return findByCriteria(crit, -1, -1);
	}
	
	@Override
	public List<T> findByCriteria(DetachedCriteria crit, int firstResult, int maxResults) {
		return dao.findByCriteria(crit, firstResult, maxResults);
	}

	@Override
	public List<T> findByExample(T example) {
		return dao.findByExample(example);
	}

	@Override
	public T findById(PK id) {
		return dao.findById(id);
	}

	@Override
	public Long count(DetachedCriteria crit) {
		return dao.count(crit);
	}

	@Override
	public Session getCurrentSession() {
		return dao.getCurrentSession();
	}


	/***********************
	 *  Getters & Setters  *
	 ***********************/

	public void setDao(GenericDao<T, PK> dao) {
		this.dao = dao;
	}


	public List<Object> executeNamedQuery(String namedQuery, String[] args, Object[] values) {

		return dao.executeNamedQuery(namedQuery, args, values);
	}

	public List<Object[]> executeNamedQueryMatrix(String namedQuery, String[] args, Object[] values) {

		return dao.executeNamedQueryMatrix(namedQuery, args, values);
	}

	@Override
	public void detach(T object) {

		dao.getCurrentSession().evict(object);

	}

	@Override
	public void detach(List<Object> listOfObjects) {

		for( Object object : listOfObjects) {
			dao.getCurrentSession().evict(object);
		}
	}

	@Override
	public void saveOrUpdate(T object) {

		//Properties of the current object
		PropertyAccessor newObjProps = PropertyAccessorFactory.forDirectFieldAccess(object);		

		Calendar cal11 = Calendar.getInstance();
		//now
		Date today = new Date(cal11.getTimeInMillis());

		newObjProps.setPropertyValue("lastUpdateTimestamp", today);
		
		if(newObjProps.getPropertyValue("creationTimestamp") == null )
		{
			newObjProps.setPropertyValue("creationTimestamp", today);
		}
		dao.getCurrentSession().saveOrUpdate(object);
	}

	@Override
	public void customSave(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(T object) {
		
		PropertyAccessor newObjProps = PropertyAccessorFactory.forDirectFieldAccess(object);		

		Calendar cal1 = Calendar.getInstance();
		Date today = new Date(cal1.getTimeInMillis());

		newObjProps.setPropertyValue("lastUpdateTimestamp", today);

		dao.getCurrentSession().merge(object);
	}
}
