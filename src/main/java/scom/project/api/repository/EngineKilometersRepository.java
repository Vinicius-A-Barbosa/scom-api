package scom.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.EngineKilometersEntity;
import scom.project.api.repository.entity.pk.EngineKilometersPK;

@Repository
public interface EngineKilometersRepository extends CrudRepository<EngineKilometersEntity, EngineKilometersPK> {
	List<EngineKilometersEntity> findAll();
	
	@Query("Select t from EngineKilometersEntity t where t.engineKilometersPK.engineCode = ?1")
	List<EngineKilometersEntity> findAllByEngine(String searchedEngine);
}
