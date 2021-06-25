package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.WheelDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.WheelRepository;

@Service
public class WheelService {
	
	@Autowired
	private WheelRepository wheelRepository;
	
	public List<WheelDTO> findAll() {
		return Mapper.convertListEntityToListDTO(wheelRepository.findAll(), WheelDTO.class);
	}
}
