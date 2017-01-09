package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 * 
 * @author nturkman
 *
 * This class defines the projects GenericaDao.
 * All data access functions should be represented in this interface
 * 
 * Entity specific methods/implementations should be created/overwritten 
 * by and extending DAO Class.
 *
 * @param <T> - Represents the implementing class of a specific DataAccessObject
 * @param <PK> - Represents the implementing class of the <T>'s primary key.
 */
public interface GenericDao <T, PK extends Serializable> {
	
	/** Create a new instance of Object<T> in the database **/
	void save (T object);
	
	/** Update an existing instance of Object<T> in the database **/
	void update (T object);
	
	/** Delete an existing instance of Object<T> from the database **/
	void delete (T object);
	
	/** Find all Object<T> according to a given criteria **/
	List<T> findByCriteria(DetachedCriteria crit);
	
	List<T> findByCriteria(DetachedCriteria crit, int firstResult, int maxResults);
	
	/** Find all Object<T> according to a given example (Object<T>) **/
	List<T> findByExample(T example);
	
	/** Returns one, and only Object<T> with an PK id **/
	T findById(PK id);
	
	/** Count number of Object<T> for a give criteria **/
	Long count(DetachedCriteria crit);
	
	/** Returns the current session **/
	Session getCurrentSession();

	/** Returns a list of objects for a specific named query */
	List<Object> executeNamedQuery(String namedQuery, String[] args, Object[] values);

	/** Returns a list of arrays for a specific named query */
	List<Object[]> executeNamedQueryMatrix(String namedQuery, String[] args, Object[] values);

}
