package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.BogieShiftEntity;
import scom.project.api.repository.entity.pk.BogieShiftPK;

@Repository
public interface BogieShiftRepository extends CrudRepository<BogieShiftEntity, BogieShiftPK> {
	List<BogieShiftEntity> findAll();
}
