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

import scom.project.api.dto.EngineDTO;
import scom.project.api.service.EngineService;

@RestController
@RequestMapping("engine")
@CrossOrigin(origins = "*")
public class EngineController {
	
	private Gson gson = new Gson();

	@Autowired
	private EngineService engineService;
	
	@GetMapping("/all")
	public List<EngineDTO> getEngineList() {
		return engineService.findAll();
	}
	
	@PutMapping("/all")
	public void saveEngineList(@RequestBody String body) {
		Type engineDTOType = new TypeToken<List<EngineDTO>>() {
		}.getType();
		
		engineService.saveAll(gson.fromJson(body, engineDTOType));
	}
	
	@PutMapping("/one")
	public void saveEngine(@RequestBody String body) {
		engineService.saveOne(gson.fromJson(body, EngineDTO.class));
	}
}
