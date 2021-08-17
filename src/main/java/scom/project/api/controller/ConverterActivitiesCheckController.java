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

import scom.project.api.dto.ConverterActivitiesCheckDTO;
import scom.project.api.service.ConverterActivitiesCheckService;

@RestController
@RequestMapping("converter/activities/check")
@CrossOrigin(origins = "*")
public class ConverterActivitiesCheckController {

	private Gson gson = new Gson();
	
	@Autowired
	private ConverterActivitiesCheckService shiftService;
	
	@GetMapping("/all")
	public List<ConverterActivitiesCheckDTO> getConverterList() {
		return shiftService.findAll();
	}
	
	@GetMapping("/all/byConverter")
	public List<ConverterActivitiesCheckDTO> getAllByConverter(@RequestBody String body) {
		return shiftService.findAllByConverter(body);
	}
	
	@PutMapping("/all")
	public void saveConverterList(@RequestBody String body) {
		Type converterDTOType = new TypeToken<List<ConverterActivitiesCheckDTO>>() {
		}.getType();
		
		shiftService.saveAll(gson.fromJson(body, converterDTOType));
	}

	@PutMapping("/one")
	public void saveConverter(@RequestBody String body) {
		shiftService.saveOne(gson.fromJson(body, ConverterActivitiesCheckDTO.class));
	}
}
