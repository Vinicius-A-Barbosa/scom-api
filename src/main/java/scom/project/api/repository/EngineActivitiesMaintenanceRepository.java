package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.EngineActivitiesMaintenanceEntity;

@Repository
public class EngineActivitiesMaintenanceRepository extends BaseRepository<EngineActivitiesMaintenanceEntity> {
	
	public List<EngineActivitiesMaintenanceEntity> findAll() {
		return super.findAll(EngineActivitiesMaintenanceEntity.class);
	}
	
	public List<EngineActivitiesMaintenanceEntity> findAllByEngine(String searchedEngine) {
		String whereClause = " WHERE m.engineActivitiesMaintenancePK.engineCode = '" + searchedEngine + "'";
		String orderBy = " ORDER BY m.engineActivitiesMaintenancePK.engineDateMaintenance";
		String clause = whereClause + orderBy;
		return super.findAll(clause, EngineActivitiesMaintenanceEntity.class);
	}
	
	@Transactional
	public void saveAll(List<EngineActivitiesMaintenanceEntity> listEngine) {
		super.saveAll(listEngine);
	}
	
	@Transactional
	public void save(EngineActivitiesMaintenanceEntity engine) {
		super.save(engine);
	}
}
