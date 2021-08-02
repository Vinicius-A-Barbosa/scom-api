package scom.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.ConverterKilometersEntity;
import scom.project.api.repository.entity.pk.ConverterKilometersPK;

@Repository
public interface ConverterKilometersRepository extends CrudRepository<ConverterKilometersEntity, ConverterKilometersPK> {
	List<ConverterKilometersEntity> findAll();
	
	@Query("Select t from ConverterKilometersEntity t where t.converterKilometersPK.converterCode = ?1")
	List<ConverterKilometersEntity> findAllByConverter(String searchedConverter);
}
