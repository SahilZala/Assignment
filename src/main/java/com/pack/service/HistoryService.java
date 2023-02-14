package com.pack.service;

import java.util.List;

import com.pack.model.History;

public interface HistoryService {
	public void createHistory(History history);
	public List<History> findByUserId(String userId);
	public List<History> getAll();
	
}
