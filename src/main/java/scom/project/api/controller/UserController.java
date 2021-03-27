package scom.project.api.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import scom.project.api.service.UserService;

@RestController
public class UserController {
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter().with(format);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/login")
	public ResponseEntity<String> getUserRole(@RequestHeader(value="login") String userLogin, @RequestHeader(value="password") String userPassword) {
		try {
			String result = userService.makeLogin(userLogin, userPassword);
			return ResponseEntity.status(HttpStatus.OK).body(ow.writeValueAsString(result));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
