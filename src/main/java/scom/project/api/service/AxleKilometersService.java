package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.AxleKilometersDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.AxleKilometersRepository;
import scom.project.api.repository.entity.AxleKilometersEntity;

@Service
public class AxleKilometersService {
	
	@Autowired
	private AxleKilometersRepository kilometersRepository;
	
	public List<AxleKilometersDTO> findAll() {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAll(), AxleKilometersDTO.class);
	}
	
	public List<AxleKilometersDTO> findAllByAxle(String axle) {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAllByAxle(axle), AxleKilometersDTO.class);
	}
	
	public void saveAll(List<AxleKilometersDTO> kmDTOList) {
		kilometersRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(kmDTOList, AxleKilometersEntity.class, "axleKilometersPK"));
	}
	
	public void saveOne(AxleKilometersDTO kmDTO) {
		kilometersRepository.save(Mapper.convertDTOToEntityWithPK(kmDTO, AxleKilometersEntity.class, "axleKilometersPK"));
	}
}
