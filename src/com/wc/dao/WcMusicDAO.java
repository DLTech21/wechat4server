package com.wc.dao;
// default package

import com.wc.bean.WcMusic;
import com.wc.jpa.EntityManagerHelper;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WcMusic entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see .WcMusic
  * @author MyEclipse Persistence Tools 
 */
public class WcMusicDAO  {
	//property constants
	public static final String MUSIC_PATH = "musicPath";
	public static final String MUSIC_NAME = "musicName";
	public static final String MUSIC_AUTHOR = "musicAuthor";
	public static final String MUSIC_SIZE = "musicSize";
	public static final String MUSIC_TYPE = "musicType";
	public static final String MUSIC_DURATION = "musicDuration";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved WcMusic entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   WcMusicDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcMusic entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(WcMusic entity) {
    				EntityManagerHelper.log("saving WcMusic instance", Level.INFO, null);
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
	 Delete a persistent WcMusic entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WcMusicDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WcMusic entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(WcMusic entity) {
    				EntityManagerHelper.log("deleting WcMusic instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(WcMusic.class, entity.getMusicId());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved WcMusic entity and return it or a copy of it to the sender. 
	 A copy of the WcMusic entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WcMusicDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcMusic entity to update
	 @return WcMusic the persisted WcMusic entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public WcMusic update(WcMusic entity) {
    				EntityManagerHelper.log("updating WcMusic instance", Level.INFO, null);
	        try {
            WcMusic result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public WcMusic findById( String id) {
    				EntityManagerHelper.log("finding WcMusic instance with id: " + id, Level.INFO, null);
	        try {
            WcMusic instance = getEntityManager().find(WcMusic.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all WcMusic entities with a specific property value.  
	 
	  @param propertyName the name of the WcMusic property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
	  	  @return List<WcMusic> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<WcMusic> findByProperty(String propertyName, final Object value
        , final int...rowStartIdxAndCount
        ) {
    				EntityManagerHelper.log("finding WcMusic instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from WcMusic model where model." 
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
	public List<WcMusic> findByMusicPath(Object musicPath
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MUSIC_PATH, musicPath
	, rowStartIdxAndCount
		);
	}
	
	public List<WcMusic> findByMusicName(Object musicName
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MUSIC_NAME, musicName
	, rowStartIdxAndCount
		);
	}
	
	public List<WcMusic> findByMusicAuthor(Object musicAuthor
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MUSIC_AUTHOR, musicAuthor
	, rowStartIdxAndCount
		);
	}
	
	public List<WcMusic> findByMusicSize(Object musicSize
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MUSIC_SIZE, musicSize
	, rowStartIdxAndCount
		);
	}
	
	public List<WcMusic> findByMusicType(Object musicType
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MUSIC_TYPE, musicType
	, rowStartIdxAndCount
		);
	}
	
	public List<WcMusic> findByMusicDuration(Object musicDuration
	, int...rowStartIdxAndCount
	) {
		return findByProperty(MUSIC_DURATION, musicDuration
	, rowStartIdxAndCount
		);
	}
	
	
	/**
	 * Find all WcMusic entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WcMusic> all WcMusic entities
	 */
	@SuppressWarnings("unchecked")
	public List<WcMusic> findAll(
		final int...rowStartIdxAndCount
		) {
					EntityManagerHelper.log("finding all WcMusic instances", Level.INFO, null);
			try {
			final String queryString = "select model from WcMusic model";
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