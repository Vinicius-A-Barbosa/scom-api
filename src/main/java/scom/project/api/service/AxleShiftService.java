package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.AxleShiftDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.AxleShiftRepository;
import scom.project.api.repository.entity.AxleShiftEntity;

@Service
public class AxleShiftService {

	@Autowired
	private AxleShiftRepository shiftRepository;
	
	public List<AxleShiftDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), AxleShiftDTO.class, "axleShiftPK");
	}
	
	public List<AxleShiftDTO> findAllByAxle(String axle) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByAxle(axle), AxleShiftDTO.class, "axleShiftPK");
	}
	
	public void saveAll(List<AxleShiftDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, AxleShiftEntity.class, "axleShiftPK"));
	}
	
	public void saveOne(AxleShiftDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, AxleShiftEntity.class, "axleShiftPK"));
	}
}
