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

import scom.project.api.dto.ConverterKilometersDTO;
import scom.project.api.service.ConverterKilometersService;

@RestController
@RequestMapping("converter/kilometers")
@CrossOrigin(origins = "*")
public class ConverterKilometersController {

	private Gson gson = new Gson();
	
	@Autowired
	private ConverterKilometersService kilometersService;
	
	@GetMapping("/all")
	public List<ConverterKilometersDTO> getConverterList() {
		return kilometersService.findAll();
	}
	
	@GetMapping("/all/byConverter")
	public List<ConverterKilometersDTO> getAllByConverter(@RequestBody String body) {
		return kilometersService.findAllByConverter(body);
	}
	
	@PutMapping("/all")
	public void saveConverterList(@RequestBody String body) {
		Type converterDTOType = new TypeToken<List<ConverterKilometersDTO>>() {
		}.getType();
		
		kilometersService.saveAll(gson.fromJson(body, converterDTOType));
	}

	@PutMapping("/one")
	public void saveConverter(@RequestBody String body) {
		kilometersService.saveOne(gson.fromJson(body, ConverterKilometersDTO.class));
	}
}
