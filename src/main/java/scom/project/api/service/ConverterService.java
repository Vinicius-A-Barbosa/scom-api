package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.ConverterDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.ConverterRepository;
import scom.project.api.repository.entity.ConverterEntity;

@Service
public class ConverterService {

	@Autowired
	private ConverterRepository converterRepository;
	
	public List<ConverterDTO> findAll() {
		return Mapper.convertListSourceToListDestination(converterRepository.findAll(), ConverterDTO.class);
	}
	
	public void saveAll(List<ConverterDTO> converterDTOList) {
		converterRepository.saveAll(Mapper.convertListSourceToListDestination(converterDTOList, ConverterEntity.class));
	}
	
	public void saveOne(ConverterDTO converterDTO) {
		converterRepository.save(Mapper.convertSourceToDestination(converterDTO, ConverterEntity.class));
	}
}
