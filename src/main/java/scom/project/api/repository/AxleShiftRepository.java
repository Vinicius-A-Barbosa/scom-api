package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.AxleShiftEntity;

@Repository
public class AxleShiftRepository extends BaseRepository<AxleShiftEntity> {
	
	public List<AxleShiftEntity> findAll() {
		return super.findAll(AxleShiftEntity.class);
	}
	
	public List<AxleShiftEntity> findAllByAxle(String searchedAxle) {
		String whereClause = " WHERE m.axleShiftPK.axleCode = '" + searchedAxle + "'";
		String orderBy = " ORDER BY m.axleShiftPK.axleDateIn";
		String clause = whereClause + orderBy;
		return super.findAll(clause, AxleShiftEntity.class);
	}
	
	@Transactional
	public void saveAll(List<AxleShiftEntity> listAxle) {
		super.saveAll(listAxle);
	}
	
	@Transactional
	public void save(AxleShiftEntity axle) {
		super.save(axle);
	}
}
