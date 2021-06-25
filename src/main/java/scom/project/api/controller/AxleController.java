package scom.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scom.project.api.dto.AxleDTO;
import scom.project.api.service.AxleService;

@RestController
@RequestMapping("axle")
@CrossOrigin(origins = "*")
public class AxleController {

	@Autowired
	private AxleService axleService;
	
	@GetMapping("/all")
	public List<AxleDTO> getAxleList() {
		return axleService.findAll();
	}
}
