package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelEntity;

@Repository
public interface WheelRepository extends CrudRepository<WheelEntity, String> {
	List<WheelEntity> findAll();
}
