package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.BogieKilometersDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.BogieKilometersRepository;
import scom.project.api.repository.entity.BogieKilometersEntity;

@Service
public class BogieKilometersService {
	
	@Autowired
	private BogieKilometersRepository kilometersRepository;
	
	public List<BogieKilometersDTO> findAll() {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAll(), BogieKilometersDTO.class);
	}
	
	public List<BogieKilometersDTO> findAllByBogie(String bogie) {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAllByBogie(bogie), BogieKilometersDTO.class);
	}
	
	public void saveAll(List<BogieKilometersDTO> kmDTOList) {
		kilometersRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(kmDTOList, BogieKilometersEntity.class, "bogieKilometersPK"));
	}
	
	public void saveOne(BogieKilometersDTO kmDTO) {
		kilometersRepository.save(Mapper.convertDTOToEntityWithPK(kmDTO, BogieKilometersEntity.class, "bogieKilometersPK"));
	}
}
