package scom.project.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.TripsHistoryEntity;

@Repository
public interface TripsHistoryRepository extends BaseRepository {
	
	public List<TripsHistoryEntity> findTripsDataById(Integer tripIdSelecter); 

}
