package com.wc.dao;
// default package

import com.wc.bean.WcLoginInfo;
import com.wc.jpa.EntityManagerHelper;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WcLoginInfo entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see .WcLoginInfo
  * @author MyEclipse Persistence Tools 
 */
public class WcLoginInfoDAO  {
	//property constants
	public static final String LOGIN_DEVICE = "loginDevice";
	public static final String LOGIN_VERSION = "loginVersion";
	public static final String LOGIN_IPADDRESS = "loginIpaddress";
	public static final String LOGIN_RESULT = "loginResult";
	public static final String USER_LOGIN_NAME = "userLoginName";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved WcLoginInfo entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   WcLoginInfoDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcLoginInfo entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(WcLoginInfo entity) {
    				EntityManagerHelper.log("saving WcLoginInfo instance", Level.INFO, null);
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
	 Delete a persistent WcLoginInfo entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WcLoginInfoDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WcLoginInfo entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(WcLoginInfo entity) {
    				EntityManagerHelper.log("deleting WcLoginInfo instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(WcLoginInfo.class, entity.getInfoId());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved WcLoginInfo entity and return it or a copy of it to the sender. 
	 A copy of the WcLoginInfo entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WcLoginInfoDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcLoginInfo entity to update
	 @return WcLoginInfo the persisted WcLoginInfo entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public WcLoginInfo update(WcLoginInfo entity) {
    				EntityManagerHelper.log("updating WcLoginInfo instance", Level.INFO, null);
	        try {
            WcLoginInfo result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public WcLoginInfo findById( String id) {
    				EntityManagerHelper.log("finding WcLoginInfo instance with id: " + id, Level.INFO, null);
	        try {
            WcLoginInfo instance = getEntityManager().find(WcLoginInfo.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all WcLoginInfo entities with a specific property value.  
	 
	  @param propertyName the name of the WcLoginInfo property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
	  	  @return List<WcLoginInfo> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<WcLoginInfo> findByProperty(String propertyName, final Object value
        , final int...rowStartIdxAndCount
        ) {
    				EntityManagerHelper.log("finding WcLoginInfo instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from WcLoginInfo model where model." 
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
	public List<WcLoginInfo> findByLoginDevice(Object loginDevice
	, int...rowStartIdxAndCount
	) {
		return findByProperty(LOGIN_DEVICE, loginDevice
	, rowStartIdxAndCount
		);
	}
	
	public List<WcLoginInfo> findByLoginVersion(Object loginVersion
	, int...rowStartIdxAndCount
	) {
		return findByProperty(LOGIN_VERSION, loginVersion
	, rowStartIdxAndCount
		);
	}
	
	public List<WcLoginInfo> findByLoginIpaddress(Object loginIpaddress
	, int...rowStartIdxAndCount
	) {
		return findByProperty(LOGIN_IPADDRESS, loginIpaddress
	, rowStartIdxAndCount
		);
	}
	
	public List<WcLoginInfo> findByLoginResult(Object loginResult
	, int...rowStartIdxAndCount
	) {
		return findByProperty(LOGIN_RESULT, loginResult
	, rowStartIdxAndCount
		);
	}
	
	public List<WcLoginInfo> findByUserLoginName(Object userLoginName
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_LOGIN_NAME, userLoginName
	, rowStartIdxAndCount
		);
	}
	
	
	/**
	 * Find all WcLoginInfo entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WcLoginInfo> all WcLoginInfo entities
	 */
	@SuppressWarnings("unchecked")
	public List<WcLoginInfo> findAll(
		final int...rowStartIdxAndCount
		) {
					EntityManagerHelper.log("finding all WcLoginInfo instances", Level.INFO, null);
			try {
			final String queryString = "select model from WcLoginInfo model";
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