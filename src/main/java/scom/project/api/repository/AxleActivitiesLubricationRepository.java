package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.AxleActivitiesLubricationEntity;
import scom.project.api.repository.entity.pk.AxleActivitiesLubricationPK;

@Repository
public interface AxleActivitiesLubricationRepository extends CrudRepository<AxleActivitiesLubricationEntity, AxleActivitiesLubricationPK> {
	List<AxleActivitiesLubricationEntity> findAll();
}
