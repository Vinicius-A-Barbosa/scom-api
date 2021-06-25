package scom.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scom.project.api.dto.ConverterDTO;
import scom.project.api.service.ConverterService;

@RestController
@RequestMapping("converter")
@CrossOrigin(origins = "*")
public class ConverterController {
	
	@Autowired
	private ConverterService converterService;
	
	@GetMapping("/all")
	public List<ConverterDTO> getConverterList() {
		return converterService.findAll();
	}
}
