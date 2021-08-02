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

import scom.project.api.dto.TrainDTO;
import scom.project.api.service.TrainService;

@RestController
@RequestMapping("train")
@CrossOrigin(origins = "*")
public class TrainController {
	
	private Gson gson = new Gson();
	
	@Autowired
	private TrainService trainService;
	
	@GetMapping("/all")
	public List<TrainDTO> getTrainList() {
		return trainService.findAll();
	}
	
	@PutMapping("/all")
	public void saveTrainList(@RequestBody String body) {
		Type trainDTOType = new TypeToken<List<TrainDTO>>() {
		}.getType();
		
		trainService.saveAll(gson.fromJson(body, trainDTOType));
	}
	
	@PutMapping("/one")
	public void saveTrain(@RequestBody String body) {
		trainService.saveOne(gson.fromJson(body, TrainDTO.class));
	}
}
