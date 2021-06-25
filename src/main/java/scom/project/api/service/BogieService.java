package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.BogieDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.BogieRepository;

@Service
public class BogieService {
	
	@Autowired
	private BogieRepository bogieRepository;
	
	public List<BogieDTO> findAll() {
		return Mapper.convertListEntityToListDTO(bogieRepository.findAll(), BogieDTO.class);
	}
}
