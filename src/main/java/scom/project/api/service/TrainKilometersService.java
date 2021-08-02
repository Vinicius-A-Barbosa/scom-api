package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.TrainKilometersDTO;
import scom.project.api.mapper.Mapper;
import scom.project.api.repository.TrainKilometersRepository;
import scom.project.api.repository.entity.TrainKilometersEntity;

@Service
public class TrainKilometersService {
	
	@Autowired
	private TrainKilometersRepository kilometersRepository;
	
	public List<TrainKilometersDTO> findAll() {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAll(), TrainKilometersDTO.class);
	}
	
	public List<TrainKilometersDTO> findAllByTrain(String train) {
		return Mapper.convertListSourceToListDestination(kilometersRepository.findAllByTrain(train), TrainKilometersDTO.class);
	}
	
	public void saveAll(List<TrainKilometersDTO> kmDTOList) {
		kilometersRepository.saveAll(Mapper.convertListDTOToListEntityWithPK(kmDTOList, TrainKilometersEntity.class, "trainKilometersPK"));
	}
	
	public void saveOne(TrainKilometersDTO kmDTO) {
		kilometersRepository.save(Mapper.convertDTOToEntityWithPK(kmDTO, TrainKilometersEntity.class, "trainKilometersPK"));
	}
}
