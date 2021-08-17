package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.BogieActivitiesRevisionEntity;

@Repository
public class BogieActivitiesRevisionRepository extends BaseRepository<BogieActivitiesRevisionEntity> {
	
	public List<BogieActivitiesRevisionEntity> findAll() {
		return super.findAll(BogieActivitiesRevisionEntity.class);
	}
	
	public List<BogieActivitiesRevisionEntity> findAllByBogie(String searchedBogie) {
		String whereClause = " WHERE m.bogieActivitiesRevisionPK.bogieCode = '" + searchedBogie + "'";
		String orderBy = " ORDER BY m.bogieActivitiesRevisionPK.bogieDateRevision";
		String clause = whereClause + orderBy;
		return super.findAll(clause, BogieActivitiesRevisionEntity.class);
	}
	
	@Transactional
	public void saveAll(List<BogieActivitiesRevisionEntity> listBogie) {
		super.saveAll(listBogie);
	}
	
	@Transactional
	public void save(BogieActivitiesRevisionEntity bogie) {
		super.save(bogie);
	}
}
