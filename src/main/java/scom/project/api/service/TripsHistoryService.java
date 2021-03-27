package scom.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scom.project.api.dto.TripsHistoryDTO;
import scom.project.api.mapper.TripsHistoryMapper;
import scom.project.api.repository.TripsHistoryRepository;
import scom.project.api.repository.entity.TripsHistoryEntity;

@Service
public class TripsHistoryService {
	@Autowired
	private TripsHistoryRepository tripsHistoryRepository; 
	
	public TripsHistoryDTO findTripsDataById(Integer tripIdSelecter) {
		List<TripsHistoryEntity> listTripsHistoryEntity = tripsHistoryRepository.findTripsDataById(tripIdSelecter);
		return TripsHistoryMapper.convertTripsHistoryListEntityToDTO(listTripsHistoryEntity);
	}
}
