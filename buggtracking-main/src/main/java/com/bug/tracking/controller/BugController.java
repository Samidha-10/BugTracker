package com.bug.tracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.tracking.modal.Bug;
import com.bug.tracking.service.BugService;
import com.bug.tracking.serviceImpl.ErrorMapValidationService;

import in.capgemini.onlineplantnurseryonline.models.Seed;



@RestController
@RequestMapping("bugs")
public class BugController {
	
	@Autowired
	private BugService bugService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService;  
	@PostMapping("createBug")
	public ResponseEntity<?> createNewBug(@Valid @RequestBody Bug bugEntity,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Bug savedBug = bugService.createBug(bugEntity);
		return new ResponseEntity<>(savedBug,HttpStatus.CREATED);
	}
	@PutMapping("/updateBug")
	public ResponseEntity<Bug> updateBug(@RequestBody Bug bug) {
		bugService.updateBug(bug);
		return new ResponseEntity<Bug>(bug,HttpStatus.CREATED);
	}
	@GetMapping("view/{id}")
	public ResponseEntity<?> getBugById(@PathVariable Long id){
			Bug bugEntity=bugService.findBugById(id);
		return new ResponseEntity<>(bugEntity,HttpStatus.OK);
		}
	@GetMapping("viewall")
	public List<Bug> getAllBug(){
	return bugService.findAllBug();
	}
	@GetMapping("viewByStatus/{Status}")
	public ResponseEntity<List<Bug>> getAllBugsByStatus(@PathVariable String Status){
		List<Bug> bugList = bugService.getAllBugsByStatus(Status);
		return new ResponseEntity<List<Bug>>(bugList,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("delete/{bugId}")
	public ResponseEntity<?> deleteBug(@PathVariable Long bugId){
		bugService.deleteBugById(bugId);
		return new ResponseEntity<>("Bug with Id"+bugId+" deleted Successfully",HttpStatus.OK);
	}

}
