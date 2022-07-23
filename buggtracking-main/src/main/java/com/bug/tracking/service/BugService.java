package com.bug.tracking.service;

import java.util.List;

import com.bug.tracking.exception.BugIdException;
import com.bug.tracking.modal.Bug;

public interface BugService {

	public Bug createBug(Bug bug);
	public Bug updateBug(Bug bug ) throws BugIdException;
	public Bug findBugById(Long bugId) throws BugIdException;
	public List<Bug> findAllBug();
	public List<Bug> getAllBugsByStatus(String Status);
	public void deleteBugById(Long id) throws BugIdException;
}
