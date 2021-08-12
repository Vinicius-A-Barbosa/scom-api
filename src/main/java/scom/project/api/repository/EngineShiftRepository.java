package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.EngineShiftEntity;

@Repository
public class EngineShiftRepository extends BaseRepository<EngineShiftEntity> {
	
	public List<EngineShiftEntity> findAll() {
		return super.findAll(EngineShiftEntity.class);
	}
	
	public List<EngineShiftEntity> findAllByEngine(String searchedEngine) {
		String whereClause = " WHERE m.engineShiftPK.engineCode = '" + searchedEngine + "'";
		String orderBy = " ORDER BY m.engineShiftPK.engineDateIn";
		String clause = whereClause + orderBy;
		return super.findAll(clause, EngineShiftEntity.class);
	}
	
	@Transactional
	public void saveAll(List<EngineShiftEntity> listEngine) {
		super.saveAll(listEngine);
	}
	
	@Transactional
	public void save(EngineShiftEntity engine) {
		super.save(engine);
	}
}
