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

import scom.project.api.dto.EngineKilometersDTO;
import scom.project.api.service.EngineKilometersService;

@RestController
@RequestMapping("engine/kilometers")
@CrossOrigin(origins = "*")
public class EngineKilometersController {

	private Gson gson = new Gson();
	
	@Autowired
	private EngineKilometersService kilometersService;
	
	@GetMapping("/all")
	public List<EngineKilometersDTO> getEngineList() {
		return kilometersService.findAll();
	}
	
	@GetMapping("/all/byEngine")
	public List<EngineKilometersDTO> getAllByEngine(@RequestBody String body) {
		return kilometersService.findAllByEngine(body);
	}
	
	@PutMapping("/all")
	public void saveEngineList(@RequestBody String body) {
		Type engineDTOType = new TypeToken<List<EngineKilometersDTO>>() {
		}.getType();
		
		kilometersService.saveAll(gson.fromJson(body, engineDTOType));
	}

	@PutMapping("/one")
	public void saveEngine(@RequestBody String body) {
		kilometersService.saveOne(gson.fromJson(body, EngineKilometersDTO.class));
	}
}
