package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.ConverterActivitiesMaintenanceEntity;

@Repository
public class ConverterActivitiesMaintenanceRepository extends BaseRepository<ConverterActivitiesMaintenanceEntity> {
	
	public List<ConverterActivitiesMaintenanceEntity> findAll() {
		return super.findAll(ConverterActivitiesMaintenanceEntity.class);
	}
	
	public List<ConverterActivitiesMaintenanceEntity> findAllByConverter(String searchedConverter) {
		String whereClause = " WHERE m.converterActivitiesMaintenancePK.converterCode = '" + searchedConverter + "'";
		String orderBy = " ORDER BY m.converterActivitiesMaintenancePK.converterDateMaintenance";
		String clause = whereClause + orderBy;
		return super.findAll(clause, ConverterActivitiesMaintenanceEntity.class);
	}
	
	@Transactional
	public void saveAll(List<ConverterActivitiesMaintenanceEntity> listConverter) {
		super.saveAll(listConverter);
	}
	
	@Transactional
	public void save(ConverterActivitiesMaintenanceEntity converter) {
		super.save(converter);
	}
}
