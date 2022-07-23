package com.bug.tracking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bug.tracking.modal.Bug;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long>{
	List<Bug> findAll();
	List<Bug> findByStatus(String status);
	Bug findBugById(Long id);

}
