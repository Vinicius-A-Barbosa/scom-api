package scom.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scom.project.api.dto.WheelDTO;
import scom.project.api.service.WheelService;

@RestController
@RequestMapping("wheel")
@CrossOrigin(origins = "*")
public class WheelController {

	@Autowired
	private WheelService wheelService;
	
	@GetMapping("/all")
	public List<WheelDTO> getWheelList() {
		return wheelService.findAll();
	}
}
