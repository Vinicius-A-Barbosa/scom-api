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

import scom.project.api.dto.AxleShiftDTO;
import scom.project.api.service.AxleShiftService;

@RestController
@RequestMapping("axle/shift")
@CrossOrigin(origins = "*")
public class AxleShiftController {

	private Gson gson = new Gson();
	
	@Autowired
	private AxleShiftService shiftService;
	
	@GetMapping("/all")
	public List<AxleShiftDTO> getAxleList() {
		return shiftService.findAll();
	}
	
	@GetMapping("/all/byAxle")
	public List<AxleShiftDTO> getAllByAxle(@RequestBody String body) {
		return shiftService.findAllByAxle(body);
	}
	
	@PutMapping("/all")
	public void saveAxleList(@RequestBody String body) {
		Type axleDTOType = new TypeToken<List<AxleShiftDTO>>() {
		}.getType();
		
		shiftService.saveAll(gson.fromJson(body, axleDTOType));
	}

	@PutMapping("/one")
	public void saveAxle(@RequestBody String body) {
		shiftService.saveOne(gson.fromJson(body, AxleShiftDTO.class));
	}
}
