package com.pack.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pack.model.History;
import com.pack.model.User;

public interface HistoryRepository extends MongoRepository<History,String> {
	@Query("{userId: '?0'}")
	Optional<List<History>> findByUserId(String userId);
}
