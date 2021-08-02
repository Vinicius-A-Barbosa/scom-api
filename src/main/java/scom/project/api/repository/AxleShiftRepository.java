package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.AxleShiftEntity;
import scom.project.api.repository.entity.pk.AxleShiftPK;

@Repository
public interface AxleShiftRepository extends CrudRepository<AxleShiftEntity, AxleShiftPK> {
	List<AxleShiftEntity> findAll();
}
