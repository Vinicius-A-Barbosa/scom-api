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

import scom.project.api.dto.ConverterActivitiesMaintenanceDTO;
import scom.project.api.service.ConverterActivitiesMaintenanceService;

@RestController
@RequestMapping("converter/activities/maintenance")
@CrossOrigin(origins = "*")
public class ConverterActivitiesMaintenanceController {

	private Gson gson = new Gson();
	
	@Autowired
	private ConverterActivitiesMaintenanceService shiftService;
	
	@GetMapping("/all")
	public List<ConverterActivitiesMaintenanceDTO> getConverterList() {
		return shiftService.findAll();
	}
	
	@GetMapping("/all/byConverter")
	public List<ConverterActivitiesMaintenanceDTO> getAllByConverter(@RequestBody String body) {
		return shiftService.findAllByConverter(body);
	}
	
	@PutMapping("/all")
	public void saveConverterList(@RequestBody String body) {
		Type converterDTOType = new TypeToken<List<ConverterActivitiesMaintenanceDTO>>() {
		}.getType();
		
		shiftService.saveAll(gson.fromJson(body, converterDTOType));
	}

	@PutMapping("/one")
	public void saveConverter(@RequestBody String body) {
		shiftService.saveOne(gson.fromJson(body, ConverterActivitiesMaintenanceDTO.class));
	}
}
