package com.wc.dao;
// default package

import com.wc.bean.OfUser;
import com.wc.jpa.EntityManagerHelper;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for OfUser entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see .OfUser
  * @author MyEclipse Persistence Tools 
 */
public class OfUserDAO  {
	//property constants
	public static final String PLAIN_PASSWORD = "plainPassword";
	public static final String ENCRYPTED_PASSWORD = "encryptedPassword";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String CREATION_DATE = "creationDate";
	public static final String MODIFICATION_DATE = "modificationDate";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved OfUser entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   OfUserDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity OfUser entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(OfUser entity) {
    				EntityManagerHelper.log("saving OfUser instance", Level.INFO, null);
	        try {
	        	getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent OfUser entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   OfUserDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity OfUser entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(OfUser entity) {
    				EntityManagerHelper.log("deleting OfUser instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(OfUser.class, entity.getUsername());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved OfUser entity and return it or a copy of it to the sender. 
	 A copy of the OfUser entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = OfUserDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity OfUser entity to update
	 @return OfUser the persisted OfUser entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public OfUser update(OfUser entity) {
    				EntityManagerHelper.log("updating OfUser instance", Level.INFO, null);
	        try {
            OfUser result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public OfUser findById( String id) {
    				EntityManagerHelper.log("finding OfUser instance with id: " + id, Level.INFO, null);
	        try {
            OfUser instance = getEntityManager().find(OfUser.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all OfUser entities with a specific property value.  
	 
	  @param propertyName the name of the OfUser property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
	  	  @return List<OfUser> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<OfUser> findByProperty(String propertyName, final Object value
        , final int...rowStartIdxAndCount
        ) {
    				EntityManagerHelper.log("finding OfUser instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from OfUser model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {	
						int rowStartIdx = Math.max(0,rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}
		
						if (rowStartIdxAndCount.length > 1) {
					    	int rowCount = Math.max(0,rowStartIdxAndCount[1]);
					    	if (rowCount > 0) {
					    		query.setMaxResults(rowCount);    
					    	}
						}
					}										
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<OfUser> findByPlainPassword(Object plainPassword
	, int...rowStartIdxAndCount
	) {
		return findByProperty(PLAIN_PASSWORD, plainPassword
	, rowStartIdxAndCount
		);
	}
	
	public List<OfUser> findByEncryptedPassword(Object encryptedPassword
	, int...rowStartIdxAndCount
	) {
		return findByProperty(ENCRYPTED_PASSWORD, encryptedPassword
	, rowStartIdxAndCount
		);
	}
	
	public List<OfUser> findByName(Object name
	, int...rowStartIdxAndCount
	) {
		return findByProperty(NAME, name
	, rowStartIdxAndCount
		);
	}
	
	public List<OfUser> findByEmail(Object email
	, int...rowStartIdxAndCount
	) {
		return findByProperty(EMAIL, email
	, rowStartIdxAndCount
		);
	}
	
	public List<OfUser> findByCreationDate(Object creationDate
	, int...rowStartIdxAndCount
	) {
		return findByProperty(CREATION_DATE, creationDate
	, rowStartIdxAndCount
		);
	}
	
	public List<OfUser> findByModificationDate(Object modificationDate
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MODIFICATION_DATE, modificationDate
	, rowStartIdxAndCount
		);
	}
	
	
	/**
	 * Find all OfUser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<OfUser> all OfUser entities
	 */
	@SuppressWarnings("unchecked")
	public List<OfUser> findAll(
		final int...rowStartIdxAndCount
		) {
					EntityManagerHelper.log("finding all OfUser instances", Level.INFO, null);
			try {
			final String queryString = "select model from OfUser model";
								Query query = getEntityManager().createQuery(queryString);
					if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {	
						int rowStartIdx = Math.max(0,rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}
		
						if (rowStartIdxAndCount.length > 1) {
					    	int rowCount = Math.max(0,rowStartIdxAndCount[1]);
					    	if (rowCount > 0) {
					    		query.setMaxResults(rowCount);    
					    	}
						}
					}										
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}