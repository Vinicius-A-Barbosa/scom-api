package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.ConverterShiftDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.ConverterShiftRepository;
import scom.project.api.repository.entity.ConverterShiftEntity;

@Service
public class ConverterShiftService {

	@Autowired
	private ConverterShiftRepository shiftRepository;
	
	public List<ConverterShiftDTO> findAll() {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAll(), ConverterShiftDTO.class, "converterShiftPK");
	}
	
	public List<ConverterShiftDTO> findAllByConverter(String converter) {
		return Mapper.convertListEntityWithPKToListDTO(shiftRepository.findAllByConverter(converter), ConverterShiftDTO.class, "converterShiftPK");
	}
	
	public void saveAll(List<ConverterShiftDTO> shiftDTOList) {
		shiftRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(shiftDTOList, ConverterShiftEntity.class, "converterShiftPK"));
	}
	
	public void saveOne(ConverterShiftDTO shiftDTO) {
		shiftRepository.save(Mapper.convertDTOToEntityWithPK(shiftDTO, ConverterShiftEntity.class, "converterShiftPK"));
	}
}
