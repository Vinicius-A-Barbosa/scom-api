package scom.project.api.repository;

import java.util.List;

import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class BaseRepository<T> {
	
	@PersistenceContext
	protected EntityManager em;
	
	public void save(T obj) {
		try {			
			em.merge(obj);
		} finally {
			em.close();
		}
	}
	
	public void saveAll(List<T> list) {
		try {
			em.clear();
			for (T obj : list) {
				em.merge(obj);
			}
		} finally {
			em.close();
		}
	}

	public T delete(Class<T> c, Object id) {
		T obj = em.find(c, id);

		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return obj;
	}

	public List<T> findAll(Class<T> c) {
		List<T> resultList;
		try {
			em.clear();
			String queryString = "SELECT m from " + c.getSimpleName() + " m";
			Query query = em.createQuery(queryString, c);
			query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
			resultList = query.getResultList(); 
		} finally {
			em.close();
		}
		return resultList;
	}
	
	public List<T> findAll(String clauses, Class<T> c) {
		List<T> resultList;
		try {
			em.clear();
			String initialQuery = "SELECT m from " + c.getSimpleName() + " m ";
			String finalQuery = initialQuery + clauses;
			Query query = em.createQuery(finalQuery, c);
			query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
			resultList = query.getResultList(); 
		} finally {
			em.close();
		}
		return resultList;
	}
	
	public List<T> findPageable(Integer page, Class<T> c) {
		List<T> resultList;
		try {
			em.clear();
			String initialQuery = "SELECT m from " + c.getSimpleName() + " m ";
			Query query = em.createQuery(initialQuery, c);
			query.setFirstResult(page);
			query.setMaxResults(10);
			query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
			resultList = query.getResultList(); 
		} finally {
			em.close();
		}
		return resultList;
	}
	
	public Long getTotal(Class<T> c) {
		Long result;
		try {
			em.clear();
			String queryString = "SELECT COUNT(*) from " + c.getSimpleName() + " m WHERE 1=1";
			Query query = em.createQuery(queryString);
			query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
			result = (Long) query.getSingleResult();
		} finally {
			em.close();
		}
		return result;
	}
	
	public void truncateTable(Class<T> entityType) {
		try {
			em.getTransaction().begin();
		    em.createQuery("DELETE FROM " + entityType.getSimpleName()).executeUpdate();
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void baseProcedureCaller(String queryString) {
		try {	
			em.getTransaction().begin();
			Query procedureQuery = em.createNativeQuery(queryString);
			procedureQuery.executeUpdate();
			em.getTransaction().commit();
			em.clear();
		} finally {
			em.close();
		}
	}
}
