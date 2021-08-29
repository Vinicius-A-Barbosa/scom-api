package scom.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scom.project.api.dto.LastKmTrainDTO;
import scom.project.api.service.LastKmTrainService;

@RestController
@RequestMapping("train/lastKm")
@CrossOrigin(origins = "*")
public class LastKmTrainController {
	
	@Autowired
	private LastKmTrainService lastKmTrainService;
	
	@GetMapping("/pageable")
	public List<LastKmTrainDTO> getTrainList(@RequestBody String page) {
		return lastKmTrainService.findAllByPage(page);
	}
	
	@GetMapping("/total")
	public Long getAllByTrain() {
		return lastKmTrainService.findTotal();
	}
}
