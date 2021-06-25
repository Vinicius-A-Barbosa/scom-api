package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.ConverterEntity;

@Repository
public interface ConverterRepository extends CrudRepository<ConverterEntity, String> {
	List<ConverterEntity> findAll();
}
