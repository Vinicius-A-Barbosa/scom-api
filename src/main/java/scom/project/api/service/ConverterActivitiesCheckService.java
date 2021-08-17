package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.ConverterActivitiesCheckDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.ConverterActivitiesCheckRepository;
import scom.project.api.repository.entity.ConverterActivitiesCheckEntity;

@Service
public class ConverterActivitiesCheckService {

	@Autowired
	private ConverterActivitiesCheckRepository shiftRepository;
	
	public List<ConverterActivitiesCheckDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), ConverterActivitiesCheckDTO.class, "converterActivitiesCheckPK");
	}
	
	public List<ConverterActivitiesCheckDTO> findAllByConverter(String converter) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByConverter(converter), ConverterActivitiesCheckDTO.class, "converterActivitiesCheckPK");
	}
	
	public void saveAll(List<ConverterActivitiesCheckDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, ConverterActivitiesCheckEntity.class, "converterActivitiesCheckPK"));
	}
	
	public void saveOne(ConverterActivitiesCheckDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, ConverterActivitiesCheckEntity.class, "converterActivitiesCheckPK"));
	}
}
