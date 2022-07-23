package com.bug.tracking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.BugIdException;
import com.bug.tracking.modal.Bug;
import com.bug.tracking.repository.BugRepository;
import com.bug.tracking.service.BugService;

@Service
public class BugServiceImpl implements BugService {

	@Autowired
	private BugRepository bugRepository;
	@Override
	public Bug createBug(Bug bug) {
		try{
			bug.setId(bug.getId());
			return bugRepository.save(bug);
		}catch(Exception ex) {
			throw new BugIdException("Bug Id : "+ bug.getId() +"already exists");
		}
		
	}
	@Override
	public Bug findBugById(Long bugId) throws BugIdException{
		Bug bug=bugRepository.findBugById(bugId);
		if(bug == null)
			throw new BugIdException("Bug Id " + bugId +" does not exist");
		return bug;
	}
	@Override
	public List<Bug> findAllBug() {
		return bugRepository.findAll();
	}
	@Override
	public void deleteBugById(Long bugId) throws BugIdException{
		Bug bug = bugRepository.findBugById(bugId);
		if(bug == null)
			throw new BugIdException("Bug Id " + bugId +" does not exist");
		bugRepository.delete(bug);
		
	}
	@Override
	public Bug updateBug(Bug bug) throws BugIdException {
			Bug bugOptional = bugRepository.findBugById(bug.getId());
			if(bugOptional==null) {
				throw new BugIdException("Invalid Bug Id.....Cannot Update");
				
			}
			bugOptional.setBugName(bugOptional.getBugName());
		return bugRepository.save(bugOptional);
	}
	@Override
	public List<Bug> getAllBugsByStatus(String Status) {
		
		return bugRepository.findByStatus(Status);
	}
	
}
