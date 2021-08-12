package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.ConverterActivitiesMaintenanceDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.ConverterActivitiesMaintenanceRepository;
import scom.project.api.repository.entity.ConverterActivitiesMaintenanceEntity;

@Service
public class ConverterActivitiesMaintenanceService {

	@Autowired
	private ConverterActivitiesMaintenanceRepository shiftRepository;
	
	public List<ConverterActivitiesMaintenanceDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), ConverterActivitiesMaintenanceDTO.class, "converterActivitiesMaintenancePK");
	}
	
	public List<ConverterActivitiesMaintenanceDTO> findAllByConverter(String converter) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByConverter(converter), ConverterActivitiesMaintenanceDTO.class, "converterActivitiesMaintenancePK");
	}
	
	public void saveAll(List<ConverterActivitiesMaintenanceDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, ConverterActivitiesMaintenanceEntity.class, "converterActivitiesMaintenancePK"));
	}
	
	public void saveOne(ConverterActivitiesMaintenanceDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, ConverterActivitiesMaintenanceEntity.class, "converterActivitiesMaintenancePK"));
	}
}
