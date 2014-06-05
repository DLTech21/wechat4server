package com.wc.dao;
// default package

import com.wc.bean.WcMessages;
import com.wc.jpa.EntityManagerHelper;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WcMessages entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see .WcMessages
  * @author MyEclipse Persistence Tools 
 */
public class WcMessagesDAO  {
	//property constants
	public static final String MESSAGE_TITLE = "messageTitle";
	public static final String MESSAGE_CONTENT = "messageContent";
	public static final String SENDER_ID = "senderId";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved WcMessages entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   WcMessagesDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcMessages entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(WcMessages entity) {
    				EntityManagerHelper.log("saving WcMessages instance", Level.INFO, null);
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
	 Delete a persistent WcMessages entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WcMessagesDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WcMessages entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(WcMessages entity) {
    				EntityManagerHelper.log("deleting WcMessages instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(WcMessages.class, entity.getMessageId());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved WcMessages entity and return it or a copy of it to the sender. 
	 A copy of the WcMessages entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WcMessagesDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcMessages entity to update
	 @return WcMessages the persisted WcMessages entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public WcMessages update(WcMessages entity) {
    				EntityManagerHelper.log("updating WcMessages instance", Level.INFO, null);
	        try {
            WcMessages result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public WcMessages findById( Integer id) {
    				EntityManagerHelper.log("finding WcMessages instance with id: " + id, Level.INFO, null);
	        try {
            WcMessages instance = getEntityManager().find(WcMessages.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all WcMessages entities with a specific property value.  
	 
	  @param propertyName the name of the WcMessages property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
	  	  @return List<WcMessages> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<WcMessages> findByProperty(String propertyName, final Object value
        , final int...rowStartIdxAndCount
        ) {
    				EntityManagerHelper.log("finding WcMessages instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from WcMessages model where model." 
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
	public List<WcMessages> findByMessageTitle(Object messageTitle
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MESSAGE_TITLE, messageTitle
	, rowStartIdxAndCount
		);
	}
	
	public List<WcMessages> findByMessageContent(Object messageContent
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MESSAGE_CONTENT, messageContent
	, rowStartIdxAndCount
		);
	}
	
	public List<WcMessages> findBySenderId(Object senderId
	, int...rowStartIdxAndCount
	) {
		return findByProperty(SENDER_ID, senderId
	, rowStartIdxAndCount
		);
	}
	
	
	/**
	 * Find all WcMessages entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WcMessages> all WcMessages entities
	 */
	@SuppressWarnings("unchecked")
	public List<WcMessages> findAll(
		final int...rowStartIdxAndCount
		) {
					EntityManagerHelper.log("finding all WcMessages instances", Level.INFO, null);
			try {
			final String queryString = "select model from WcMessages model";
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