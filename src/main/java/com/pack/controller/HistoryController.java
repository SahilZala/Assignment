package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.model.History;
import com.pack.service.HistoryService;

@RestController
@CrossOrigin
public class HistoryController {
	
	@Autowired
	HistoryService historyService;
	
	@GetMapping("/admin/history/get")
	public ResponseEntity<List<History>> getHistory(){
		return new ResponseEntity<>(historyService.getAll(),HttpStatus.OK);
	}
}
