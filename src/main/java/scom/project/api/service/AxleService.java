package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.AxleDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.AxleRepository;

@Service
public class AxleService {
	
	@Autowired
	private AxleRepository axleRepository;
	
	public List<AxleDTO> findAll() {
		return Mapper.convertListEntityToListDTO(axleRepository.findAll(), AxleDTO.class);
	}
}
