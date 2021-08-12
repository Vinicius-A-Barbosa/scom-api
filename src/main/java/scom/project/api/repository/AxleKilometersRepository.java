package scom.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.AxleKilometersEntity;
import scom.project.api.repository.entity.pk.AxleKilometersPK;

@Repository
public interface AxleKilometersRepository extends CrudRepository<AxleKilometersEntity, AxleKilometersPK> {
	List<AxleKilometersEntity> findAll();
	
	@Query("Select t from AxleKilometersEntity t where t.axleKilometersPK.axleCode = ?1")
	List<AxleKilometersEntity> findAllByAxle(String searchedAxle);
}
