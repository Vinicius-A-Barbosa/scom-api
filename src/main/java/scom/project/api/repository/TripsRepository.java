package scom.project.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.TripsEntity;

@Repository
public interface TripsRepository extends BaseRepository  {
	
	public List<TripsEntity> findAllTrips(); 
}
