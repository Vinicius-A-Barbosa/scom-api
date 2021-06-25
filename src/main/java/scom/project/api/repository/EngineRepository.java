package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.EngineEntity;

@Repository
public interface EngineRepository extends CrudRepository<EngineEntity, String> {
	List<EngineEntity> findAll();
}
