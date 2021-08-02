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

import scom.project.api.dto.WheelDTO;
import scom.project.api.service.WheelService;

@RestController
@RequestMapping("wheel")
@CrossOrigin(origins = "*")
public class WheelController {
	
	private Gson gson = new Gson();

	@Autowired
	private WheelService wheelService;
	
	@GetMapping("/all")
	public List<WheelDTO> getWheelList() {
		return wheelService.findAll();
	}
	
	@PutMapping("/all")
	public void saveWheelList(@RequestBody String body) {
		Type wheelDTOType = new TypeToken<List<WheelDTO>>() {
		}.getType();
		
		wheelService.saveAll(gson.fromJson(body, wheelDTOType));
	}
	
	@PutMapping("/one")
	public void saveWheel(@RequestBody String body) {
		wheelService.saveOne(gson.fromJson(body, WheelDTO.class));
	}
}
