package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.EngineShiftDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.EngineShiftRepository;
import scom.project.api.repository.entity.EngineShiftEntity;

@Service
public class EngineShiftService {

	@Autowired
	private EngineShiftRepository shiftRepository;
	
	public List<EngineShiftDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), EngineShiftDTO.class, "engineShiftPK");
	}
	
	public List<EngineShiftDTO> findAllByEngine(String engine) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByEngine(engine), EngineShiftDTO.class, "engineShiftPK");
	}
	
	public void saveAll(List<EngineShiftDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, EngineShiftEntity.class, "engineShiftPK"));
	}
	
	public void saveOne(EngineShiftDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, EngineShiftEntity.class, "engineShiftPK"));
	}
}
