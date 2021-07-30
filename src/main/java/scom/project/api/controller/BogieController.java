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

import scom.project.api.dto.BogieDTO;
import scom.project.api.service.BogieService;

@RestController
@RequestMapping("bogie")
@CrossOrigin(origins = "*")
public class BogieController {
	
	private Gson gson = new Gson();

	@Autowired
	private BogieService bogieService;
	
	@GetMapping("/all")
	public List<BogieDTO> getBogieList() {
		return bogieService.findAll();
	}
	
	@PutMapping("/all")
	public void saveBogieList(@RequestBody String body) {
		Type bogieDTOType = new TypeToken<List<BogieDTO>>() {
		}.getType();
		
		bogieService.saveAll(gson.fromJson(body, bogieDTOType));
	}
	
	@PutMapping("/one")
	public void saveBogie(@RequestBody String body) {
		bogieService.saveOne(gson.fromJson(body, BogieDTO.class));
	}
}
