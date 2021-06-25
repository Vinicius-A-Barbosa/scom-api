package scom.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scom.project.api.dto.BogieDTO;
import scom.project.api.service.BogieService;

@RestController
@RequestMapping("bogie")
@CrossOrigin(origins = "*")
public class BogieController {

	@Autowired
	private BogieService bogieService;
	
	@GetMapping("/all")
	public List<BogieDTO> getBogieList() {
		return bogieService.findAll();
	}
}
