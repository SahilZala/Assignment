package com.pack.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pack.model.History;
import org.springframework.http.ResponseEntity;
import com.pack.service.HistoryService;

@RestController
@CrossOrigin
public class LogoutController {
	
	
	@Autowired
	HistoryService historyService;
	
	
	@PostMapping("/logou")
	public ResponseEntity<History> logout(HttpServletRequest req) {
		String token = req.getHeader("Authorization").substring(7);
		return new ResponseEntity<>(historyService.updateHistory(token),HttpStatus.OK);
	}
}
