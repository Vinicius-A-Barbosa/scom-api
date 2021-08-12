package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.EngineActivitiesCheckEntity;

@Repository
public class EngineActivitiesCheckRepository extends BaseRepository<EngineActivitiesCheckEntity> {
	
	public List<EngineActivitiesCheckEntity> findAll() {
		return super.findAll(EngineActivitiesCheckEntity.class);
	}
	
	public List<EngineActivitiesCheckEntity> findAllByEngine(String searchedEngine) {
		String whereClause = " WHERE m.engineActivitiesCheckPK.engineCode = '" + searchedEngine + "'";
		String orderBy = " ORDER BY m.engineActivitiesCheckPK.checkDateIn";
		String clause = whereClause + orderBy;
		return super.findAll(clause, EngineActivitiesCheckEntity.class);
	}
	
	@Transactional
	public void saveAll(List<EngineActivitiesCheckEntity> listEngine) {
		super.saveAll(listEngine);
	}
	
	@Transactional
	public void save(EngineActivitiesCheckEntity engine) {
		super.save(engine);
	}
}
