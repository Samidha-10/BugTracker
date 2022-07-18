package com.bugTracker.project.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class IBugController {
	
	@Autowired
	private IBugServiceImpl IBugService;
	

@GetMapping("/admin/bugs/getByStatus/{status}")
public List<Bug> getBug(@PathVariable String status) {
	return (List<Bug>) (IBugService.getAllBugsByStatus(status)); 
}
	
 @PutMapping("/admin/updateBugs")
 public void updateBug(@RequestBody long id, @RequestBody Bug bug) {
	 IBugService.updateBug(id, bug);
 }
 
 @GetMapping("/admin/getBugs")
 public ResponseEntity<List<Bug>> getAllBugs(){
  List<Bug> bugList = IBugService.getAllBugs();
  return new ResponseEntity<List<Bug>>(bugList,HttpStatus.ACCEPTED);
 }
 
 @DeleteMapping("/admin/bugs/{id}")
 public void deleteBug(@PathVariable int id){
  IBugService.deleteBug(id);
 }
 
 //Admin can create bugs...
 
 @PostMapping("/admin/bug")
 public Bug createBug(@RequestBody Bug bug) {
	 return IBugService.createBug(bug);
 }
 	
}