package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.ConverterKilometersDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.ConverterKilometersRepository;
import scom.project.api.repository.entity.ConverterKilometersEntity;

@Service
public class ConverterKilometersService {

	@Autowired
	private ConverterKilometersRepository kilometersRepository;
	
	public List<ConverterKilometersDTO> findAll() {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAll(), ConverterKilometersDTO.class);
	}
	
	public List<ConverterKilometersDTO> findAllByConverter(String converter) {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAllByConverter(converter), ConverterKilometersDTO.class);
	}
	
	public void saveAll(List<ConverterKilometersDTO> kmDTOList) {
		kilometersRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(kmDTOList, ConverterKilometersEntity.class, "converterKilometersPK"));
	}
	
	public void saveOne(ConverterKilometersDTO kmDTO) {
		kilometersRepository.save(Mapper.convertDTOToEntityWithPK(kmDTO, ConverterKilometersEntity.class, "converterKilometersPK"));
	}
}
