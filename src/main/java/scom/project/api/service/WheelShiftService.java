package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.WheelShiftDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.WheelShiftRepository;
import scom.project.api.repository.entity.WheelShiftEntity;

@Service
public class WheelShiftService {

	@Autowired
	private WheelShiftRepository shiftRepository;
	
	public List<WheelShiftDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), WheelShiftDTO.class, "wheelShiftPK");
	}
	
	public List<WheelShiftDTO> findAllByWheel(String wheel) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByWheel(wheel), WheelShiftDTO.class, "wheelShiftPK");
	}
	
	public void saveAll(List<WheelShiftDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, WheelShiftEntity.class, "wheelShiftPK"));
	}
	
	public void saveOne(WheelShiftDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, WheelShiftEntity.class, "wheelShiftPK"));
	}
}
