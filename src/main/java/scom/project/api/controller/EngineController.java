package scom.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scom.project.api.dto.EngineDTO;
import scom.project.api.service.EngineService;

@RestController
@RequestMapping("engine")
@CrossOrigin(origins = "*")
public class EngineController {

	@Autowired
	private EngineService engineService;
	
	@GetMapping("/all")
	public List<EngineDTO> getEngineList() {
		return engineService.findAll();
	}
}
