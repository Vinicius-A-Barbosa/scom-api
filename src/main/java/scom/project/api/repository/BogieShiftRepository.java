package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.BogieShiftEntity;

@Repository
public class BogieShiftRepository extends BaseRepository<BogieShiftEntity> {
	
	public List<BogieShiftEntity> findAll() {
		return super.findAll(BogieShiftEntity.class);
	}
	
	public List<BogieShiftEntity> findAllByBogie(String searchedBogie) {
		String whereClause = " WHERE m.bogieShiftPK.bogieCode = '" + searchedBogie + "'";
		String orderBy = " ORDER BY m.bogieShiftPK.bogieDateIn";
		String clause = whereClause + orderBy;
		return super.findAll(clause, BogieShiftEntity.class);
	}
	
	@Transactional
	public void saveAll(List<BogieShiftEntity> listBogie) {
		super.saveAll(listBogie);
	}
	
	@Transactional
	public void save(BogieShiftEntity bogie) {
		super.save(bogie);
	}
}
