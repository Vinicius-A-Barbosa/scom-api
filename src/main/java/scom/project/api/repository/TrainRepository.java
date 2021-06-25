package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.TrainEntity;

@Repository
public interface TrainRepository extends CrudRepository<TrainEntity, String> {
	List<TrainEntity> findAll();
}
