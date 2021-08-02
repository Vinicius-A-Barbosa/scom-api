package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.ConverterActivitiesMaintenanceEntity;
import scom.project.api.repository.entity.pk.ConverterActivitiesMaintenancePK;

@Repository
public interface ConverterActivitiesMaintenanceRepository extends CrudRepository<ConverterActivitiesMaintenanceEntity, ConverterActivitiesMaintenancePK> {
	List<ConverterActivitiesMaintenanceEntity> findAll();
}
