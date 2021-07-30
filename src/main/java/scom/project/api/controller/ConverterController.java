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

import scom.project.api.dto.ConverterDTO;
import scom.project.api.service.ConverterService;

@RestController
@RequestMapping("converter")
@CrossOrigin(origins = "*")
public class ConverterController {
	
	private Gson gson = new Gson();
	
	@Autowired
	private ConverterService converterService;
	
	@GetMapping("/all")
	public List<ConverterDTO> getConverterList() {
		return converterService.findAll();
	}
	
	@PutMapping("/all")
	public void saveConverterList(@RequestBody String body) {
		Type converterDTOType = new TypeToken<List<ConverterDTO>>() {
		}.getType();
		
		converterService.saveAll(gson.fromJson(body, converterDTOType));
	}
	
	@PutMapping("/one")
	public void saveConverter(@RequestBody String body) {
		converterService.saveOne(gson.fromJson(body, ConverterDTO.class));
	}
}
