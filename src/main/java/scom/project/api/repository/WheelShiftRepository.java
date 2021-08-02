package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelShiftEntity;
import scom.project.api.repository.entity.pk.WheelShiftPK;

@Repository
public interface WheelShiftRepository extends CrudRepository<WheelShiftEntity, WheelShiftPK> {
	List<WheelShiftEntity> findAll();
}
