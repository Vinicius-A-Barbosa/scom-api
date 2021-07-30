package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.BogieDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.BogieRepository;
import scom.project.api.repository.entity.BogieEntity;

@Service
public class BogieService {
	
	@Autowired
	private BogieRepository bogieRepository;
	
	public List<BogieDTO> findAll() {
		return Mapper.convertListSourceToListDestination(bogieRepository.findAll(), BogieDTO.class);
	}
	
	public void saveAll(List<BogieDTO> bogieDTOList) {
		bogieRepository.saveAll(Mapper.convertListSourceToListDestination(bogieDTOList, BogieEntity.class));
	}
	
	public void saveOne(BogieDTO bogieDTO) {
		bogieRepository.save(Mapper.convertSourceToDestination(bogieDTO, BogieEntity.class));
	}
}
