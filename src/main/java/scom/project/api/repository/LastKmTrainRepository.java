package scom.project.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.LastKmTrainEntity;

@Repository
public class LastKmTrainRepository extends BaseRepository<LastKmTrainEntity> {
	
	public Long findTotal() {
		return super.getTotal(LastKmTrainEntity.class);
	}
	
	public List<LastKmTrainEntity> findAllPageable(String page) {
		Integer offset = Integer.parseInt(page) * 10;
		return super.findPageable(offset, LastKmTrainEntity.class);
	}
}
