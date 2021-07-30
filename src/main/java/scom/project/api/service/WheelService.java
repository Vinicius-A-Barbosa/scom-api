package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.WheelDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.WheelRepository;
import scom.project.api.repository.entity.WheelEntity;

@Service
public class WheelService {
	
	@Autowired
	private WheelRepository wheelRepository;
	
	public List<WheelDTO> findAll() {
		return Mapper.convertListSourceToListDestination(wheelRepository.findAll(), WheelDTO.class);
	}
	
	public void saveAll(List<WheelDTO> wheelDTOList) {
		wheelRepository.saveAll(Mapper.convertListSourceToListDestination(wheelDTOList, WheelEntity.class));
	}
	
	public void saveOne(WheelDTO wheelDTO) {
		wheelRepository.save(Mapper.convertSourceToDestination(wheelDTO, WheelEntity.class));
	}
}
