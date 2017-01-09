package bo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public interface GenericBo <T, PK extends Serializable> {

	/** Create a new instance of Object<T> in the database **/
	void save (T object);
	
	/** Create a new instance of Object<T> in the database **/
	void customSave(T object);
	
	/** Creates or updates an instance of Object<T> in the database **/
	void saveOrUpdate (T object);
	
	/** Update an existing instance of Object<T> in the database **/
	void update (T object);
	
	/** Delete an existing instance of Object<T> from the database **/
	void delete (T object);
	
	/** Merges an existing instance of Object<T> from the database **/
	void merge (T object);
	
	/** Find all Object<T> according to a given criteria **/
	List<T> findByCriteria(DetachedCriteria crit);
	
	/** Find all Object<T> according to a given criteria **/
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
	
	/** Returns a matrix for a specific named query */
	List<Object[]> executeNamedQueryMatrix(String namedQuery, String[] args, Object[] values);
	
	/** Detach element **/
	void detach(T object);
	
	/** Detach the objects in a list from session */
	void detach( List<Object> listOfObjects);

}
	
