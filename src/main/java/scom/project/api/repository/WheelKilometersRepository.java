package scom.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.WheelKilometersEntity;
import scom.project.api.repository.entity.pk.WheelKilometersPK;

@Repository
public interface WheelKilometersRepository extends CrudRepository<WheelKilometersEntity, WheelKilometersPK> {
	List<WheelKilometersEntity> findAll();
	
	@Query("Select t from WheelKilometersEntity t where t.wheelKilometersPK.wheelCode = ?1")
	List<WheelKilometersEntity> findAllByWheel(String searchedWheel);
}
