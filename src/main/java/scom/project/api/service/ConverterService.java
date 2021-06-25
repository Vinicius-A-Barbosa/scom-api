package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.ConverterDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.ConverterRepository;

@Service
public class ConverterService {

	@Autowired
	private ConverterRepository converterRepository;
	
	public List<ConverterDTO> findAll() {
		return Mapper.convertListEntityToListDTO(converterRepository.findAll(), ConverterDTO.class);
	}
}
