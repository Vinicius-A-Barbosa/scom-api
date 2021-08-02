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

import scom.project.api.dto.WheelKilometersDTO;
import scom.project.api.service.WheelKilometersService;

@RestController
@RequestMapping("wheel/kilometers")
@CrossOrigin(origins = "*")
public class WheelKilometersController {

	private Gson gson = new Gson();
	
	@Autowired
	private WheelKilometersService kilometersService;
	
	@GetMapping("/all")
	public List<WheelKilometersDTO> getWheelList() {
		return kilometersService.findAll();
	}
	
	@GetMapping("/all/byWheel")
	public List<WheelKilometersDTO> getAllByWheel(@RequestBody String body) {
		return kilometersService.findAllByWheel(body);
	}
	
	@PutMapping("/all")
	public void saveWheelList(@RequestBody String body) {
		Type wheelDTOType = new TypeToken<List<WheelKilometersDTO>>() {
		}.getType();
		
		kilometersService.saveAll(gson.fromJson(body, wheelDTOType));
	}

	@PutMapping("/one")
	public void saveWheel(@RequestBody String body) {
		kilometersService.saveOne(gson.fromJson(body, WheelKilometersDTO.class));
	}
}
