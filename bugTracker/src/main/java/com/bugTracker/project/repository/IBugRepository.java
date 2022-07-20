package com.bugTracker.project.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bugTracker.project.modal.Bug;


@Repository
public interface IBugRepository extends CrudRepository<Bug, Integer> {

	Optional<Bug> findById(long id);

	void deleteById(long id);

	List<Bug> findByStatus(String status);

}
