package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.WheelKilometersDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.WheelKilometersRepository;
import scom.project.api.repository.entity.WheelKilometersEntity;

@Service
public class WheelKilometersService {

	@Autowired
	private WheelKilometersRepository kilometersRepository;
	
	public List<WheelKilometersDTO> findAll() {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAll(), WheelKilometersDTO.class);
	}
	
	public List<WheelKilometersDTO> findAllByWheel(String wheel) {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAllByWheel(wheel), WheelKilometersDTO.class);
	}
	
	public void saveAll(List<WheelKilometersDTO> kmDTOList) {
		kilometersRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(kmDTOList, WheelKilometersEntity.class, "wheelKilometersPK"));
	}
	
	public void saveOne(WheelKilometersDTO kmDTO) {
		kilometersRepository.save(Mapper.convertDTOToEntityWithPK(kmDTO, WheelKilometersEntity.class, "wheelKilometersPK"));
	}
}
