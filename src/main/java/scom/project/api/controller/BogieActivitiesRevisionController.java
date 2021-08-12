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

import scom.project.api.dto.BogieActivitiesRevisionDTO;
import scom.project.api.service.BogieActivitiesRevisionService;

@RestController
@RequestMapping("bogie/activities/revision")
@CrossOrigin(origins = "*")
public class BogieActivitiesRevisionController {

	private Gson gson = new Gson();
	
	@Autowired
	private BogieActivitiesRevisionService shiftService;
	
	@GetMapping("/all")
	public List<BogieActivitiesRevisionDTO> getBogieList() {
		return shiftService.findAll();
	}
	
	@GetMapping("/all/byBogie")
	public List<BogieActivitiesRevisionDTO> getAllByBogie(@RequestBody String body) {
		return shiftService.findAllByBogie(body);
	}
	
	@PutMapping("/all")
	public void saveBogieList(@RequestBody String body) {
		Type bogieDTOType = new TypeToken<List<BogieActivitiesRevisionDTO>>() {
		}.getType();
		
		shiftService.saveAll(gson.fromJson(body, bogieDTOType));
	}

	@PutMapping("/one")
	public void saveBogie(@RequestBody String body) {
		shiftService.saveOne(gson.fromJson(body, BogieActivitiesRevisionDTO.class));
	}
}
