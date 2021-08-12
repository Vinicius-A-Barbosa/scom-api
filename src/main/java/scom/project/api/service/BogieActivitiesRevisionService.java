package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.BogieActivitiesRevisionDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.BogieActivitiesRevisionRepository;
import scom.project.api.repository.entity.BogieActivitiesRevisionEntity;

@Service
public class BogieActivitiesRevisionService {

	@Autowired
	private BogieActivitiesRevisionRepository shiftRepository;
	
	public List<BogieActivitiesRevisionDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), BogieActivitiesRevisionDTO.class, "bogieActivitiesRevisionPK");
	}
	
	public List<BogieActivitiesRevisionDTO> findAllByBogie(String bogie) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByBogie(bogie), BogieActivitiesRevisionDTO.class, "bogieActivitiesRevisionPK");
	}
	
	public void saveAll(List<BogieActivitiesRevisionDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, BogieActivitiesRevisionEntity.class, "bogieActivitiesRevisionPK"));
	}
	
	public void saveOne(BogieActivitiesRevisionDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, BogieActivitiesRevisionEntity.class, "bogieActivitiesRevisionPK"));
	}
}
