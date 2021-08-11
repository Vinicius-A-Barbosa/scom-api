package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelShiftEntity;

@Repository
public class WheelShiftRepository extends BaseRepository<WheelShiftEntity> {
	
	public List<WheelShiftEntity> findAll() {
		return super.findAll(WheelShiftEntity.class);
	}
	
	public List<WheelShiftEntity> findAllByWheel(String searchedWheel) {
		String whereClause = " WHERE m.wheelShiftPK.wheelCode = '" + searchedWheel + "'";
		String orderBy = " ORDER BY m.wheelShiftPK.wheelDateIn";
		String clause = whereClause + orderBy;
		return super.findAll(clause, WheelShiftEntity.class);
	}
	
	@Transactional
	public void saveAll(List<WheelShiftEntity> listWheel) {
		super.saveAll(listWheel);
	}
	
	@Transactional
	public void save(WheelShiftEntity wheel) {
		super.save(wheel);
	}
}
