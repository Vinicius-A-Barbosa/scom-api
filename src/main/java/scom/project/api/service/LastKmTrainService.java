package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.LastKmTrainDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.LastKmTrainRepository;

@Service
public class LastKmTrainService {
	
	@Autowired
	private LastKmTrainRepository lastKmTrainRepository;
	
	public Long findTotal() {
		return lastKmTrainRepository.findTotal();
	}
	
	public List<LastKmTrainDTO> findAllByPage(String page) {
		return Mapper.convertListSourceToListDestination(lastKmTrainRepository.findAllPageable(page), LastKmTrainDTO.class);
	}
}
