package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.AxleActivitiesLubricationEntity;

@Repository
public class AxleActivitiesLubricationRepository extends BaseRepository<AxleActivitiesLubricationEntity> {
	
	public List<AxleActivitiesLubricationEntity> findAll() {
		return super.findAll(AxleActivitiesLubricationEntity.class);
	}
	
	public List<AxleActivitiesLubricationEntity> findAllByAxle(String searchedAxle) {
		String whereClause = " WHERE m.axleActivitiesLubricationPK.axleCode = '" + searchedAxle + "'";
		String orderBy = " ORDER BY m.axleActivitiesLubricationPK.axleDateLubrication";
		String clause = whereClause + orderBy;
		return super.findAll(clause, AxleActivitiesLubricationEntity.class);
	}
	
	@Transactional
	public void saveAll(List<AxleActivitiesLubricationEntity> listAxle) {
		super.saveAll(listAxle);
	}
	
	@Transactional
	public void save(AxleActivitiesLubricationEntity axle) {
		super.save(axle);
	}
}
