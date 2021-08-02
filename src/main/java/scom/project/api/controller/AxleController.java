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

import scom.project.api.dto.AxleDTO;
import scom.project.api.service.AxleService;

@RestController
@RequestMapping("axle")
@CrossOrigin(origins = "*")
public class AxleController {
	
	private Gson gson = new Gson();

	@Autowired
	private AxleService axleService;
	
	@GetMapping("/all")
	public List<AxleDTO> getAxleList() {
		return axleService.findAll();
	}
	
	@PutMapping("/all")
	public void saveAxleList(@RequestBody String body) {
		Type axleDTOType = new TypeToken<List<AxleDTO>>() {
		}.getType();
		
		axleService.saveAll(gson.fromJson(body, axleDTOType));
	}
	
	@PutMapping("/one")
	public void saveAxle(@RequestBody String body) {
		axleService.saveOne(gson.fromJson(body, AxleDTO.class));
	}
}
