package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.ConverterActivitiesCheckEntity;

@Repository
public class ConverterActivitiesCheckRepository extends BaseRepository<ConverterActivitiesCheckEntity> {
	
	public List<ConverterActivitiesCheckEntity> findAll() {
		return super.findAll(ConverterActivitiesCheckEntity.class);
	}
	
	public List<ConverterActivitiesCheckEntity> findAllByConverter(String searchedConverter) {
		String whereClause = " WHERE m.converterActivitiesCheckPK.converterCode = '" + searchedConverter + "'";
		String orderBy = " ORDER BY m.converterActivitiesCheckPK.checkDateIn";
		String clause = whereClause + orderBy;
		return super.findAll(clause, ConverterActivitiesCheckEntity.class);
	}
	
	@Transactional
	public void saveAll(List<ConverterActivitiesCheckEntity> listConverter) {
		super.saveAll(listConverter);
	}
	
	@Transactional
	public void save(ConverterActivitiesCheckEntity converter) {
		super.save(converter);
	}
}
