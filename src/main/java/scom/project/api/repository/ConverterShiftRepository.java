package scom.project.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import scom.project.api.repository.entity.ConverterShiftEntity;

@Repository
public class ConverterShiftRepository extends BaseRepository<ConverterShiftEntity> {
	
	public List<ConverterShiftEntity> findAll() {
		return super.findAll(ConverterShiftEntity.class);
	}
	
	public List<ConverterShiftEntity> findAllByConverter(String searchedConverter) {
		String whereClause = " WHERE m.converterShiftPK.converterCode = " + searchedConverter;
		String orderBy = " ORDER BY m.converterShiftPK.converterDateIn";
		String clause = whereClause + orderBy;
		return super.findAll(clause, ConverterShiftEntity.class);
	}
	
	@Transactional
	public void saveAll(List<ConverterShiftEntity> listConverter) {
		super.saveAll(listConverter);
	}
	
	@Transactional
	public void save(ConverterShiftEntity converter) {
		super.save(converter);
	}
}
