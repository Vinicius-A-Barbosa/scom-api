package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelActivitiesMachiningEntity;

@Repository
public class WheelActivitiesMachiningRepository extends BaseRepository<WheelActivitiesMachiningEntity> {
	
	public List<WheelActivitiesMachiningEntity> findAll() {
		return super.findAll(WheelActivitiesMachiningEntity.class);
	}
	
	public List<WheelActivitiesMachiningEntity> findAllByWheel(String searchedWheel) {
		String whereClause = " WHERE m.wheelActivitiesMachiningPK.wheelCode = '" + searchedWheel + "'";
		String orderBy = " ORDER BY m.wheelActivitiesMachiningPK.wheelDateMachining";
		String clause = whereClause + orderBy;
		return super.findAll(clause, WheelActivitiesMachiningEntity.class);
	}
	
	@Transactional
	public void saveAll(List<WheelActivitiesMachiningEntity> listWheel) {
		super.saveAll(listWheel);
	}
	
	@Transactional
	public void save(WheelActivitiesMachiningEntity wheel) {
		super.save(wheel);
	}
}
