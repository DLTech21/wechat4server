package com.wc.dao;
// default package

import com.wc.bean.WcUser;
import com.wc.jpa.EntityManagerHelper;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WcUser entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see .WcUser
  * @author MyEclipse Persistence Tools 
 */
public class WcUserDAO  {
	//property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_NICKNAME = "userNickname";
	public static final String USER_DESCRIPTION = "userDescription";
	public static final String USER_HEAD = "userHead";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String CITY = "city";
	public static final String PROVINCE = "province";
	public static final String USER_SEX = "userSex";
	public static final String USER_AGE = "userAge";
	public static final String USER_QQ = "userQq";
	public static final String USER_PHONE = "userPhone";
	public static final String API_KEY = "apiKey";
	public static final String USER_STATE = "userState";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved WcUser entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   WcUserDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcUser entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(WcUser entity) {
    				EntityManagerHelper.log("saving WcUser instance", Level.INFO, null);
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
	 Delete a persistent WcUser entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WcUserDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WcUser entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(WcUser entity) {
    				EntityManagerHelper.log("deleting WcUser instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(WcUser.class, entity.getUserId());
        	getEntityManager().getTransaction().begin();
            getEntityManager().remove(entity);
            getEntityManager().getTransaction().commit();
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved WcUser entity and return it or a copy of it to the sender. 
	 A copy of the WcUser entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WcUserDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WcUser entity to update
	 @return WcUser the persisted WcUser entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public WcUser update(WcUser entity) {
    				EntityManagerHelper.log("updating WcUser instance", Level.INFO, null);
	        try {
	        	getEntityManager().getTransaction().begin();
            WcUser result = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public WcUser findById( String id) {
    				EntityManagerHelper.log("finding WcUser instance with id: " + id, Level.INFO, null);
	        try {
            WcUser instance = getEntityManager().find(WcUser.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all WcUser entities with a specific property value.  
	 
	  @param propertyName the name of the WcUser property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
	  	  @return List<WcUser> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<WcUser> findByProperty(String propertyName, final Object value
        , final int...rowStartIdxAndCount
        ) {
    				EntityManagerHelper.log("finding WcUser instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from WcUser model where model." 
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
					getEntityManager().clear();
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<WcUser> findByUserName(Object userName
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_NAME, userName
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserPassword(Object userPassword
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_PASSWORD, userPassword
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserNickname(Object userNickname
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_NICKNAME, userNickname
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserDescription(Object userDescription
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_DESCRIPTION, userDescription
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserHead(Object userHead
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_HEAD, userHead
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByLongitude(Object longitude
	, int...rowStartIdxAndCount
	) {
		return findByProperty(LONGITUDE, longitude
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByLatitude(Object latitude
	, int...rowStartIdxAndCount
	) {
		return findByProperty(LATITUDE, latitude
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByCity(Object city
	, int...rowStartIdxAndCount
	) {
		return findByProperty(CITY, city
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByProvince(Object province
	, int...rowStartIdxAndCount
	) {
		return findByProperty(PROVINCE, province
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserSex(Object userSex
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_SEX, userSex
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserAge(Object userAge
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_AGE, userAge
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserQq(Object userQq
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_QQ, userQq
	, rowStartIdxAndCount
		);
	}
	
	public List<WcUser> findByUserPhone(Object userPhone
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_PHONE, userPhone
	, rowStartIdxAndCount
		);
	}
	
	public WcUser findByApiKey(Object apiKey
	, int...rowStartIdxAndCount
	) {
		
		List<WcUser> list=findByProperty(API_KEY, apiKey
				, rowStartIdxAndCount);
		return list.size()==0?null:list.get(0);
	}
	
	public List<WcUser> findByUserState(Object userState
	, int...rowStartIdxAndCount
	) {
		return findByProperty(USER_STATE, userState
	, rowStartIdxAndCount
		);
	}
	
	
	/**
	 * Find all WcUser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WcUser> all WcUser entities
	 */
	@SuppressWarnings("unchecked")
	public List<WcUser> findAll(
		final int...rowStartIdxAndCount
		) {
					EntityManagerHelper.log("finding all WcUser instances", Level.INFO, null);
			try {
			final String queryString = "select model from WcUser model order by model.userId desc";
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
					getEntityManager().clear();
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}

	public WcUser findByMobile(Object mobile) {
		// TODO Auto-generated method stub
		
					List<WcUser> l=findByProperty("userName", mobile
							);
					if (l.size()==0) {
						return null;
					}
					
					else return l.get(0);
		
	}

	public List<WcUser> searchByUserNickname(String nickName, final int...rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("根据昵称模糊搜索", Level.INFO, null);
		try {
			nickName="%"+nickName+"%";
		final String queryString = "select model from WcUser model where model.userNickname like ?1 order by model.userId desc";
							Query query = getEntityManager().createQuery(queryString);
							query.setParameter(1, nickName);
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
				getEntityManager().clear();
				return query.getResultList();
	} catch (RuntimeException re) {
					EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
	}
	}

	public List<WcUser> findByFriend(WcUser me, final int...rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("查找好友", Level.INFO, null);
		try {
		final String queryString = "select model from WcUser model where model IN ?1 order by model.userId desc";
							Query query = getEntityManager().createQuery(queryString);
							query.setParameter(1, me.getFriends());
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
				getEntityManager().clear();
				return query.getResultList();
	} catch (RuntimeException re) {
					EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
	}
	}
	
}