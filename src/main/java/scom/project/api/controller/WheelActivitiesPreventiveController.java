package scom.project.api.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import scom.project.api.dto.WheelActivitiesPreventiveDTO;
import scom.project.api.service.WheelActivitiesPreventiveService;

@RestController
@RequestMapping("wheel/activities/preventive")
@CrossOrigin(origins = "*")
public class WheelActivitiesPreventiveController {

	private Gson gson = new Gson();
	
	@Autowired
	private WheelActivitiesPreventiveService shiftService;
	
	@GetMapping("/all")
	public List<WheelActivitiesPreventiveDTO> getWheelList() {
		return shiftService.findAll();
	}
	
	@GetMapping("/all/byWheel")
	public List<WheelActivitiesPreventiveDTO> getAllByWheel(@RequestBody String body) {
		return shiftService.findAllByWheel(body);
	}
	
	@PutMapping("/all")
	public void saveWheelList(@RequestBody String body) {
		Type wheelDTOType = new TypeToken<List<WheelActivitiesPreventiveDTO>>() {
		}.getType();
		
		shiftService.saveAll(gson.fromJson(body, wheelDTOType));
	}

	@PutMapping("/one")
	public void saveWheel(@RequestBody String body) {
		shiftService.saveOne(gson.fromJson(body, WheelActivitiesPreventiveDTO.class));
	}
}
