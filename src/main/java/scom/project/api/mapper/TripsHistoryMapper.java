package scom.project.api.mapper;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import scom.project.api.dto.TripsHistoryDTO;
import scom.project.api.repository.entity.TripsHistoryEntity;

public class TripsHistoryMapper {
	
	public static TripsHistoryDTO convertTripsHistoryListEntityToDTO(List<TripsHistoryEntity> listTripsHistoryEntity) {
		TripsHistoryDTO tripsHistoryDTO = new TripsHistoryDTO();
		tripsHistoryDTO.setTripId(listTripsHistoryEntity.get(0).getId().getTripId());
		List<LocalTime> tripTime = new ArrayList<>();
		List<Double> aceleration = new ArrayList<>();
		List<Double> position = new ArrayList<>();
		List<Double> torque = new ArrayList<>();
		List<Double> frequency = new ArrayList<>();
		List<Double> velocity = new ArrayList<>();
		List<Boolean> emergency = new ArrayList<>();
		List<Double> curve = new ArrayList<>();
		List<Double> inclination = new ArrayList<>();
		for(TripsHistoryEntity tripsHistoryEntity : listTripsHistoryEntity) {
			tripTime.add(tripsHistoryEntity.getId().getTripTime());
			aceleration.add(tripsHistoryEntity.getAceleration());
			position.add(tripsHistoryEntity.getPosition());
			torque.add(tripsHistoryEntity.getTorque());
			frequency.add(tripsHistoryEntity.getFrequency());
			velocity.add(tripsHistoryEntity.getVelocity());
			emergency.add(tripsHistoryEntity.getEmergency());
			curve.add(tripsHistoryEntity.getCurve());
			inclination.add(tripsHistoryEntity.getInclination());
		}
		tripsHistoryDTO.setTripTime(tripTime);
		tripsHistoryDTO.setAceleration(aceleration);
		tripsHistoryDTO.setPosition(position);
		tripsHistoryDTO.setTorque(torque);
		tripsHistoryDTO.setFrequency(frequency);
		tripsHistoryDTO.setVelocity(velocity);
		tripsHistoryDTO.setEmergency(emergency);
		tripsHistoryDTO.setCurve(curve);
		tripsHistoryDTO.setInclination(inclination);
		
		return tripsHistoryDTO;
	}
}
