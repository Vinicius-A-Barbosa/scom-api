package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.WheelActivitiesMachiningDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.WheelActivitiesMachiningRepository;
import scom.project.api.repository.entity.WheelActivitiesMachiningEntity;

@Service
public class WheelActivitiesMachiningService {

	@Autowired
	private WheelActivitiesMachiningRepository shiftRepository;
	
	public List<WheelActivitiesMachiningDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), WheelActivitiesMachiningDTO.class, "wheelActivitiesMachiningPK");
	}
	
	public List<WheelActivitiesMachiningDTO> findAllByWheel(String wheel) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByWheel(wheel), WheelActivitiesMachiningDTO.class, "wheelActivitiesMachiningPK");
	}
	
	public void saveAll(List<WheelActivitiesMachiningDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, WheelActivitiesMachiningEntity.class, "wheelActivitiesMachiningPK"));
	}
	
	public void saveOne(WheelActivitiesMachiningDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, WheelActivitiesMachiningEntity.class, "wheelActivitiesMachiningPK"));
	}
}
