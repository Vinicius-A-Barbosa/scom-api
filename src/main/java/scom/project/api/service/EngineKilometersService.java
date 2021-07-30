package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.EngineKilometersDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.EngineKilometersRepository;
import scom.project.api.repository.entity.EngineKilometersEntity;

@Service
public class EngineKilometersService {

	@Autowired
	private EngineKilometersRepository kilometersRepository;
	
	public List<EngineKilometersDTO> findAll() {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAll(), EngineKilometersDTO.class);
	}
	
	public List<EngineKilometersDTO> findAllByEngine(String engine) {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAllByEngine(engine), EngineKilometersDTO.class);
	}
	
	public void saveAll(List<EngineKilometersDTO> kmDTOList) {
		kilometersRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(kmDTOList, EngineKilometersEntity.class, "engineKilometersPK"));
	}
	
	public void saveOne(EngineKilometersDTO kmDTO) {
		kilometersRepository.save(Mapper.convertDTOToEntityWithPK(kmDTO, EngineKilometersEntity.class, "engineKilometersPK"));
	}
}
