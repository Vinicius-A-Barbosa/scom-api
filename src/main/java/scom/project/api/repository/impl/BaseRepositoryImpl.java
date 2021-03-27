package scom.project.api.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.BaseRepository;

@Repository
public class BaseRepositoryImpl implements BaseRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public Query fillQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> clause : parameters.entrySet()) {
			query.setParameter(clause.getKey(), clause.getValue());
		}
		return query;
	}

	@Override
	public Query fillQueryPageableAndParameters(Integer page, Integer size, QueryObject whereClause, Query query) {
		query = fillQueryParameters(query, whereClause.getParameters());
		if (page != null && size != null) {
			query.setFirstResult(page * size);
			query.setMaxResults(size);
		}
		return query;
	}
	
	public <T> List<T> castResultList(Class<? extends T> objectClass, Collection<?> inputCollection) {
	    if (inputCollection == null) {
	    	return null;
	    }
	    
		List<T> targetList = new ArrayList<T>(inputCollection.size());
	    for (Object objectCollection: inputCollection)
	      targetList.add(objectClass.cast(objectCollection));
	    
	    return targetList;
	}

}
