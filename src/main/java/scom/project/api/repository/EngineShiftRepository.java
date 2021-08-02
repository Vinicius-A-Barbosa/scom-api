package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.EngineShiftEntity;
import scom.project.api.repository.entity.pk.EngineShiftPK;

@Repository
public interface EngineShiftRepository extends CrudRepository<EngineShiftEntity, EngineShiftPK> {
	List<EngineShiftEntity> findAll();
}
