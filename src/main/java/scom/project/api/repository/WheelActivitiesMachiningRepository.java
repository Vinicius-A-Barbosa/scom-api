package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelActivitiesMachiningEntity;
import scom.project.api.repository.entity.pk.WheelActivitiesMachiningPK;

@Repository
public interface WheelActivitiesMachiningRepository extends CrudRepository<WheelActivitiesMachiningEntity, WheelActivitiesMachiningPK> {
	List<WheelActivitiesMachiningEntity> findAll();
}
