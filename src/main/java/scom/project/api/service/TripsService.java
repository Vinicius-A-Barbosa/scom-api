package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.TripsDTO;
import scom.project.api.mapper.TripsMapper;
import scom.project.api.repository.TripsRepository;
import scom.project.api.repository.entity.TripsEntity;

@Service
public class TripsService {
	@Autowired
	private TripsRepository tripsRepository;
	
	public List<TripsDTO> findAllTrips() {
		List<TripsEntity> listTripsEntity = tripsRepository.findAllTrips();
		return TripsMapper.convertListTripsEntityToDTO(listTripsEntity);
	}
}
