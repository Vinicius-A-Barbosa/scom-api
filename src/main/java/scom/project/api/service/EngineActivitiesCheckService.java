package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.EngineActivitiesCheckDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.EngineActivitiesCheckRepository;
import scom.project.api.repository.entity.EngineActivitiesCheckEntity;

@Service
public class EngineActivitiesCheckService {

	@Autowired
	private EngineActivitiesCheckRepository shiftRepository;
	
	public List<EngineActivitiesCheckDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), EngineActivitiesCheckDTO.class, "engineActivitiesCheckPK");
	}
	
	public List<EngineActivitiesCheckDTO> findAllByEngine(String engine) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByEngine(engine), EngineActivitiesCheckDTO.class, "engineActivitiesCheckPK");
	}
	
	public void saveAll(List<EngineActivitiesCheckDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, EngineActivitiesCheckEntity.class, "engineActivitiesCheckPK"));
	}
	
	public void saveOne(EngineActivitiesCheckDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, EngineActivitiesCheckEntity.class, "engineActivitiesCheckPK"));
	}
}
