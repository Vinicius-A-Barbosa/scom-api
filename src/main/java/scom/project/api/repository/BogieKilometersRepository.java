package scom.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.BogieKilometersEntity;
import scom.project.api.repository.entity.pk.BogieKilometersPK;

@Repository
public interface BogieKilometersRepository extends CrudRepository<BogieKilometersEntity, BogieKilometersPK> {
	List<BogieKilometersEntity> findAll();
	
	@Query("Select b from BogieKilometersEntity b where b.bogieKilometersPK.bogieCode = ?1")
	List<BogieKilometersEntity> findAllByBogie(String searchedBogie);
}
