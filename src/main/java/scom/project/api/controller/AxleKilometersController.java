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

import scom.project.api.dto.AxleKilometersDTO;
import scom.project.api.service.AxleKilometersService;

@RestController
@RequestMapping("axle/kilometers")
@CrossOrigin(origins = "*")
public class AxleKilometersController {

	private Gson gson = new Gson();
	
	@Autowired
	private AxleKilometersService kilometersService;
	
	@GetMapping("/all")
	public List<AxleKilometersDTO> getAxleList() {
		return kilometersService.findAll();
	}
	
	@GetMapping("/all/byAxle")
	public List<AxleKilometersDTO> getAllByAxle(@RequestBody String body) {
		return kilometersService.findAllByAxle(body);
	}
	
	@PutMapping("/all")
	public void saveAxleList(@RequestBody String body) {
		Type axleDTOType = new TypeToken<List<AxleKilometersDTO>>() {
		}.getType();
		
		kilometersService.saveAll(gson.fromJson(body, axleDTOType));
	}

	@PutMapping("/one")
	public void saveAxle(@RequestBody String body) {
		kilometersService.saveOne(gson.fromJson(body, AxleKilometersDTO.class));
	}
}
