package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.TrainDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.TrainRepository;

@Service
public class TrainService {
	
	@Autowired
	private TrainRepository trainRepository;
	
	public List<TrainDTO> findAll() {
		return Mapper.convertListEntityToListDTO(trainRepository.findAll(), TrainDTO.class);
	}
}
