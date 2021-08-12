package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.EngineActivitiesMaintenanceDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.EngineActivitiesMaintenanceRepository;
import scom.project.api.repository.entity.EngineActivitiesMaintenanceEntity;

@Service
public class EngineActivitiesMaintenanceService {

	@Autowired
	private EngineActivitiesMaintenanceRepository shiftRepository;
	
	public List<EngineActivitiesMaintenanceDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), EngineActivitiesMaintenanceDTO.class, "engineActivitiesMaintenancePK");
	}
	
	public List<EngineActivitiesMaintenanceDTO> findAllByEngine(String engine) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByEngine(engine), EngineActivitiesMaintenanceDTO.class, "engineActivitiesMaintenancePK");
	}
	
	public void saveAll(List<EngineActivitiesMaintenanceDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, EngineActivitiesMaintenanceEntity.class, "engineActivitiesMaintenancePK"));
	}
	
	public void saveOne(EngineActivitiesMaintenanceDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, EngineActivitiesMaintenanceEntity.class, "engineActivitiesMaintenancePK"));
	}
}
