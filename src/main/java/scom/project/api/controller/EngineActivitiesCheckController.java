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

import scom.project.api.dto.EngineActivitiesCheckDTO;
import scom.project.api.service.EngineActivitiesCheckService;

@RestController
@RequestMapping("engine/activities/check")
@CrossOrigin(origins = "*")
public class EngineActivitiesCheckController {

	private Gson gson = new Gson();
	
	@Autowired
	private EngineActivitiesCheckService shiftService;
	
	@GetMapping("/all")
	public List<EngineActivitiesCheckDTO> getEngineList() {
		return shiftService.findAll();
	}
	
	@GetMapping("/all/byEngine")
	public List<EngineActivitiesCheckDTO> getAllByEngine(@RequestBody String body) {
		return shiftService.findAllByEngine(body);
	}
	
	@PutMapping("/all")
	public void saveEngineList(@RequestBody String body) {
		Type engineDTOType = new TypeToken<List<EngineActivitiesCheckDTO>>() {
		}.getType();
		
		shiftService.saveAll(gson.fromJson(body, engineDTOType));
	}

	@PutMapping("/one")
	public void saveEngine(@RequestBody String body) {
		shiftService.saveOne(gson.fromJson(body, EngineActivitiesCheckDTO.class));
	}
}
