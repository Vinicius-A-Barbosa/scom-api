package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import scom.project.api.repository.entity.TrainEntity;

public interface TrainRepository extends CrudRepository<TrainEntity, String> {
	List<TrainEntity> findAll();
}
