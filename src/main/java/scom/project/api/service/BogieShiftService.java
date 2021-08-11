package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.BogieShiftDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.BogieShiftRepository;
import scom.project.api.repository.entity.BogieShiftEntity;

@Service
public class BogieShiftService {

	@Autowired
	private BogieShiftRepository shiftRepository;
	
	public List<BogieShiftDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), BogieShiftDTO.class, "bogieShiftPK");
	}
	
	public List<BogieShiftDTO> findAllByBogie(String bogie) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByBogie(bogie), BogieShiftDTO.class, "bogieShiftPK");
	}
	
	public void saveAll(List<BogieShiftDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, BogieShiftEntity.class, "bogieShiftPK"));
	}
	
	public void saveOne(BogieShiftDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, BogieShiftEntity.class, "bogieShiftPK"));
	}
}
