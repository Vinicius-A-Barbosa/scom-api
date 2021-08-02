package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelActivitiesPreventiveEntity;

@Repository
public interface WheelActivitiesPreventiveRepository extends CrudRepository<WheelActivitiesPreventiveEntity, String> {
	List<WheelActivitiesPreventiveEntity> findAll();
}
