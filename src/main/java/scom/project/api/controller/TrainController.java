package scom.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scom.project.api.dto.TrainDTO;
import scom.project.api.service.TrainService;

@RestController
@RequestMapping("train")
@CrossOrigin(origins = "*")
public class TrainController {
	
	@Autowired
	TrainService trainService;
	
	@GetMapping("/all")
	public List<TrainDTO> getTrainList() {
		return trainService.findAll();
	}
}
