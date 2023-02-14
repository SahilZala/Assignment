package com.pack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.History;
import com.pack.repository.HistoryRepository;
import com.pack.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	HistoryRepository historyRepo;
	
	@Override
	public void createHistory(History history) {
		historyRepo.save(history);
	}

	@Override
	public List<History> findByUserId(String userId) {
		return historyRepo.findByUserId(userId).get();
	}
	
}
