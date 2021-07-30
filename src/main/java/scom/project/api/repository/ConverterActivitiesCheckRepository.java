package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.ConverterActivitiesCheckEntity;
import scom.project.api.repository.entity.pk.ConverterActivitiesCheckPK;

@Repository
public interface ConverterActivitiesCheckRepository extends CrudRepository<ConverterActivitiesCheckEntity, ConverterActivitiesCheckPK> {
	List<ConverterActivitiesCheckEntity> findAll();
}
