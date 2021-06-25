package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.BogieEntity;

@Repository
public interface BogieRepository extends CrudRepository<BogieEntity, String> {
	List<BogieEntity> findAll();
}
