package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.EngineDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.EngineRepository;

@Service
public class EngineService {
	
	@Autowired
	private EngineRepository engineRepository;
	
	public List<EngineDTO> findAll() {
		return Mapper.convertListEntityToListDTO(engineRepository.findAll(), EngineDTO.class);
	}
}
