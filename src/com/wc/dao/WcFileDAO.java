package com.wc.dao;
// default package

import com.wc.bean.WcFile;
import com.wc.jpa.EntityManagerHelper;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WcFile entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see .WcFile
  * @author MyEclipse Persistence Tools 
 */
public class WcFileDAO  {
	//property constants
	public static final String SHORT_PATH = "shortPath";
	public static final String FULL_PATH = "fullPath";
	public static final String UPLOAD_USER = "uploadUser";
	public static final String FILE_TYPE = "fileType";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved WcFile entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   WcFileDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcFile entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(WcFile entity) {
    				EntityManagerHelper.log("saving WcFile instance", Level.INFO, null);
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
	 Delete a persistent WcFile entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WcFileDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WcFile entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(WcFile entity) {
    				EntityManagerHelper.log("deleting WcFile instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(WcFile.class, entity.getFileId());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved WcFile entity and return it or a copy of it to the sender. 
	 A copy of the WcFile entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WcFileDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcFile entity to update
	 @return WcFile the persisted WcFile entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public WcFile update(WcFile entity) {
    				EntityManagerHelper.log("updating WcFile instance", Level.INFO, null);
	        try {
            WcFile result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public WcFile findById( String id) {
    				EntityManagerHelper.log("finding WcFile instance with id: " + id, Level.INFO, null);
	        try {
            WcFile instance = getEntityManager().find(WcFile.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all WcFile entities with a specific property value.  
	 
	  @param propertyName the name of the WcFile property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
	  	  @return List<WcFile> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<WcFile> findByProperty(String propertyName, final Object value
        , final int...rowStartIdxAndCount
        ) {
    				EntityManagerHelper.log("finding WcFile instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from WcFile model where model." 
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
	public List<WcFile> findByShortPath(Object shortPath
	, int...rowStartIdxAndCount
	) {
		return findByProperty(SHORT_PATH, shortPath
	, rowStartIdxAndCount
		);
	}
	
	public List<WcFile> findByFullPath(Object fullPath
	, int...rowStartIdxAndCount
	) {
		return findByProperty(FULL_PATH, fullPath
	, rowStartIdxAndCount
		);
	}
	
	public List<WcFile> findByUploadUser(Object uploadUser
	, int...rowStartIdxAndCount
	) {
		return findByProperty(UPLOAD_USER, uploadUser
	, rowStartIdxAndCount
		);
	}
	
	public List<WcFile> findByFileType(Object fileType
	, int...rowStartIdxAndCount
	) {
		return findByProperty(FILE_TYPE, fileType
	, rowStartIdxAndCount
		);
	}
	
	
	/**
	 * Find all WcFile entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WcFile> all WcFile entities
	 */
	@SuppressWarnings("unchecked")
	public List<WcFile> findAll(
		final int...rowStartIdxAndCount
		) {
					EntityManagerHelper.log("finding all WcFile instances", Level.INFO, null);
			try {
			final String queryString = "select model from WcFile model";
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