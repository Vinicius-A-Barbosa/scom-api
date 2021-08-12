package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.WheelActivitiesPreventiveDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.WheelActivitiesPreventiveRepository;
import scom.project.api.repository.entity.WheelActivitiesPreventiveEntity;

@Service
public class WheelActivitiesPreventiveService {

	@Autowired
	private WheelActivitiesPreventiveRepository shiftRepository;
	
	public List<WheelActivitiesPreventiveDTO> findAll() {
		return Mapper.convertListSourceToListDestination(shiftRepository.findAll(), WheelActivitiesPreventiveDTO.class);
	}
	
	public List<WheelActivitiesPreventiveDTO> findAllByWheel(String wheel) {
		return Mapper.convertListSourceToListDestination(shiftRepository.findAllByWheel(wheel), WheelActivitiesPreventiveDTO.class);
	}
	
	public void saveAll(List<WheelActivitiesPreventiveDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListSourceToListDestination(shiftDTOList, WheelActivitiesPreventiveEntity.class));
	}
	
	public void saveOne(WheelActivitiesPreventiveDTO shiftDTO) {
		shiftRepository.save(Mapper.convertSourceToDestination(shiftDTO, WheelActivitiesPreventiveEntity.class));
	}
}
