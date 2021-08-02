package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.EngineDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.EngineRepository;
import scom.project.api.repository.entity.EngineEntity;

@Service
public class EngineService {
	
	@Autowired
	private EngineRepository engineRepository;
	
	public List<EngineDTO> findAll() {
		return Mapper.convertListSourceToListDestination(engineRepository.findAll(), EngineDTO.class);
	}
	
	public void saveAll(List<EngineDTO> engineDTOList) {
		engineRepository.saveAll(Mapper.convertListSourceToListDestination(engineDTOList, EngineEntity.class));
	}
	
	public void saveOne(EngineDTO engineDTO) {
		engineRepository.save(Mapper.convertSourceToDestination(engineDTO, EngineEntity.class));
	}
}
