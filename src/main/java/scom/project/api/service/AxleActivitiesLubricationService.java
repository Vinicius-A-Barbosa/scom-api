package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.AxleActivitiesLubricationDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.AxleActivitiesLubricationRepository;
import scom.project.api.repository.entity.AxleActivitiesLubricationEntity;

@Service
public class AxleActivitiesLubricationService {

	@Autowired
	private AxleActivitiesLubricationRepository shiftRepository;
	
	public List<AxleActivitiesLubricationDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), AxleActivitiesLubricationDTO.class, "axleActivitiesLubricationPK");
	}
	
	public List<AxleActivitiesLubricationDTO> findAllByAxle(String axle) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByAxle(axle), AxleActivitiesLubricationDTO.class, "axleActivitiesLubricationPK");
	}
	
	public void saveAll(List<AxleActivitiesLubricationDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, AxleActivitiesLubricationEntity.class, "axleActivitiesLubricationPK"));
	}
	
	public void saveOne(AxleActivitiesLubricationDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, AxleActivitiesLubricationEntity.class, "axleActivitiesLubricationPK"));
	}
}
