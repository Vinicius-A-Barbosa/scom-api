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

import scom.project.api.dto.BogieKilometersDTO;
import scom.project.api.service.BogieKilometersService;

@RestController
@RequestMapping("bogie/kilometers")
@CrossOrigin(origins = "*")
public class BogieKilometersController {

	private Gson gson = new Gson();
	
	@Autowired
	private BogieKilometersService kilometersService;
	
	@GetMapping("/all")
	public List<BogieKilometersDTO> getBogieList() {
		return kilometersService.findAll();
	}
	
	@GetMapping("/all/byBogie")
	public List<BogieKilometersDTO> getAllByBogie(@RequestBody String body) {
		return kilometersService.findAllByBogie(body);
	}
	
	@PutMapping("/all")
	public void saveBogieList(@RequestBody String body) {
		Type bogieDTOType = new TypeToken<List<BogieKilometersDTO>>() {
		}.getType();
		
		kilometersService.saveAll(gson.fromJson(body, bogieDTOType));
	}

	@PutMapping("/one")
	public void saveBogie(@RequestBody String body) {
		kilometersService.saveOne(gson.fromJson(body, BogieKilometersDTO.class));
	}
}
