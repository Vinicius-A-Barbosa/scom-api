package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.AxleDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.AxleRepository;
import scom.project.api.repository.entity.AxleEntity;

@Service
public class AxleService {
	
	@Autowired
	private AxleRepository axleRepository;
	
	public List<AxleDTO> findAll() {
		return Mapper.convertListSourceToListDestination(axleRepository.findAll(), AxleDTO.class);
	}
	
	public void saveAll(List<AxleDTO> axleDTOList) {
		axleRepository.saveAll(Mapper.convertListSourceToListDestination(axleDTOList, AxleEntity.class));
	}
	
	public void saveOne(AxleDTO axleDTO) {
		axleRepository.save(Mapper.convertSourceToDestination(axleDTO, AxleEntity.class));
	}
}
