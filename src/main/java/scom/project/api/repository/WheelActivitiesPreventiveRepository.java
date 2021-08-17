package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelActivitiesPreventiveEntity;

@Repository
public class WheelActivitiesPreventiveRepository extends BaseRepository<WheelActivitiesPreventiveEntity> {
	
	public List<WheelActivitiesPreventiveEntity> findAll() {
		return super.findAll(WheelActivitiesPreventiveEntity.class);
	}
	
	public List<WheelActivitiesPreventiveEntity> findAllByWheel(String searchedWheel) {
		String whereClause = " WHERE m.wheelCode = '" + searchedWheel + "'";
		String orderBy = " ORDER BY m.preventiveDateFlangeRim, m.preventiveDateBearingSurface";
		String clause = whereClause + orderBy;
		return super.findAll(clause, WheelActivitiesPreventiveEntity.class);
	}
	
	@Transactional
	public void saveAll(List<WheelActivitiesPreventiveEntity> listWheel) {
		super.saveAll(listWheel);
	}
	
	@Transactional
	public void save(WheelActivitiesPreventiveEntity wheel) {
		super.save(wheel);
	}
}
