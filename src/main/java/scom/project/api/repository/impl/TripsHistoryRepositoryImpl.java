package scom.project.api.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.TripsHistoryRepository;
import scom.project.api.repository.entity.TripsHistoryEntity;

@Repository
public class TripsHistoryRepositoryImpl extends BaseRepositoryImpl implements TripsHistoryRepository {
	
	@Override
	@Transactional
	public List<TripsHistoryEntity> findTripsDataById(Integer tripIdSelecter) {
		String queryText = "SELECT m FROM TripsHistoryEntity m WHERE m.id.tripId = :tripIdSelecter ORDER BY m.id.tripTime";
		Query query = em.createQuery(queryText, TripsHistoryEntity.class);
		query.setParameter("tripIdSelecter", tripIdSelecter);
		return query.getResultList();
	}
}
