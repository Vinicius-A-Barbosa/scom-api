package scom.project.api.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.TripsRepository;
import scom.project.api.repository.entity.TripsEntity;

@Repository
public class TripsRepositoryImpl extends BaseRepositoryImpl implements TripsRepository{
	
	@Override
	@Transactional
	public List<TripsEntity> findAllTrips() {
		String queryText = "SELECT m FROM TripsEntity m ORDER BY m.tripId";
		Query query = em.createQuery(queryText, TripsEntity.class);
		return query.getResultList();
	}
}
