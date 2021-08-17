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

import scom.project.api.dto.EngineActivitiesMaintenanceDTO;
import scom.project.api.service.EngineActivitiesMaintenanceService;

@RestController
@RequestMapping("engine/activities/maintenance")
@CrossOrigin(origins = "*")
public class EngineActivitiesMaintenanceController {

	private Gson gson = new Gson();
	
	@Autowired
	private EngineActivitiesMaintenanceService shiftService;
	
	@GetMapping("/all")
	public List<EngineActivitiesMaintenanceDTO> getEngineList() {
		return shiftService.findAll();
	}
	
	@GetMapping("/all/byEngine")
	public List<EngineActivitiesMaintenanceDTO> getAllByEngine(@RequestBody String body) {
		return shiftService.findAllByEngine(body);
	}
	
	@PutMapping("/all")
	public void saveEngineList(@RequestBody String body) {
		Type engineDTOType = new TypeToken<List<EngineActivitiesMaintenanceDTO>>() {
		}.getType();
		
		shiftService.saveAll(gson.fromJson(body, engineDTOType));
	}

	@PutMapping("/one")
	public void saveEngine(@RequestBody String body) {
		shiftService.saveOne(gson.fromJson(body, EngineActivitiesMaintenanceDTO.class));
	}
}
