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

import scom.project.api.dto.TrainKilometersDTO;
import scom.project.api.service.TrainKilometersService;

@RestController
@RequestMapping("train/kilometers")
@CrossOrigin(origins = "*")
public class TrainKilometersController {
	
	private Gson gson = new Gson();
	
	@Autowired
	private TrainKilometersService kilometersService;
	
	@GetMapping("/all")
	public List<TrainKilometersDTO> getTrainList() {
		return kilometersService.findAll();
	}
	
	@GetMapping("/all/byTrain")
	public List<TrainKilometersDTO> getAllByTrain(@RequestBody String body) {
		return kilometersService.findAllByTrain(body);
	}
	
	@PutMapping("/all")
	public void saveTrainList(@RequestBody String body) {
		Type trainDTOType = new TypeToken<List<TrainKilometersDTO>>() {
		}.getType();
		
		kilometersService.saveAll(gson.fromJson(body, trainDTOType));
	}

	@PutMapping("/one")
	public void saveTrain(@RequestBody String body) {
		kilometersService.saveOne(gson.fromJson(body, TrainKilometersDTO.class));
	}
}
