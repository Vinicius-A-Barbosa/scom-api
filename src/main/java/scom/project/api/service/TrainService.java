package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.TrainDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.TrainRepository;
import scom.project.api.repository.entity.TrainEntity;

@Service
public class TrainService {
	
	@Autowired
	private TrainRepository trainRepository;
	
	public List<TrainDTO> findAll() {
		return Mapper.convertListSourceToListDestination(trainRepository.findAll(), TrainDTO.class);
	}
	
	public void saveAll(List<TrainDTO> trainDTOList) {
		trainRepository.saveAll(Mapper.convertListSourceToListDestination(trainDTOList, TrainEntity.class));
	}
	
	public void saveOne(TrainDTO trainDTO) {
		trainRepository.save(Mapper.convertSourceToDestination(trainDTO, TrainEntity.class));
	}
}
