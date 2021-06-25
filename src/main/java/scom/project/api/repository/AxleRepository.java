package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.AxleEntity;

@Repository
public interface AxleRepository extends CrudRepository<AxleEntity, String>{
	List<AxleEntity> findAll();
}
