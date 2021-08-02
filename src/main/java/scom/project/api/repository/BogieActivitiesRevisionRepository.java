package scom.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.BogieActivitiesRevisionEntity;
import scom.project.api.repository.entity.pk.BogieActivitiesRevisionPK;

@Repository
public interface BogieActivitiesRevisionRepository extends CrudRepository<BogieActivitiesRevisionEntity, BogieActivitiesRevisionPK> {
	List<BogieActivitiesRevisionEntity> findAll();
}
