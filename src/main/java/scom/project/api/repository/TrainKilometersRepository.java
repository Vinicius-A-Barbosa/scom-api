package scom.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.TrainKilometersEntity;
import scom.project.api.repository.entity.pk.TrainKilometersPK;

@Repository
public interface TrainKilometersRepository extends CrudRepository<TrainKilometersEntity, TrainKilometersPK> {
	List<TrainKilometersEntity> findAll();
	
	@Query("Select t from TrainKilometersEntity t where t.trainKilometersPK.trainCode = ?1")
	List<TrainKilometersEntity> findAllByTrain(String searchedTrain);
}
