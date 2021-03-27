package scom.project.api.mapper;

import java.util.ArrayList;
import java.util.List;

import scom.project.api.dto.TripsDTO;
import scom.project.api.repository.entity.TripsEntity;

public class TripsMapper {
	
	public static TripsDTO convertTripsEntityToDTO(TripsEntity tripsEntity) {
		TripsDTO tripsDTO = new TripsDTO();
		tripsDTO.setTripId(tripsEntity.getTripId());
		tripsDTO.setDepartureStation(tripsEntity.getDepartureStation());
		tripsDTO.setArrivalStation(tripsEntity.getArrivalStation());
		tripsDTO.setTrainId(tripsEntity.getTrainId());
		tripsDTO.setInitialTripsDate(tripsEntity.getInitialTripsDateHour().toLocalDate());
		tripsDTO.setFinalTripsDate(tripsEntity.getFinalTripsDateHour().toLocalDate());
		tripsDTO.setInitialTripsTime(tripsEntity.getInitialTripsDateHour().toLocalTime());
		tripsDTO.setFinalTripsTime(tripsEntity.getFinalTripsDateHour().toLocalTime());
		
		return tripsDTO;
	}
	
	public static List<TripsDTO> convertListTripsEntityToDTO(List<TripsEntity> listTripsEntity) {
		List<TripsDTO> listTripsDTO = new ArrayList<>();
		for (TripsEntity tripsEntity : listTripsEntity) {
			listTripsDTO.add(convertTripsEntityToDTO(tripsEntity));
		}
		return listTripsDTO;
	}
}
