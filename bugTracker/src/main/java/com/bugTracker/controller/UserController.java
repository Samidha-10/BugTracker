package com.bug.tracking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.tracking.execption.ResourceNotFoundException;
import com.bug.tracking.model.User;
import com.bug.tracking.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("view")
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	@GetMapping("view/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="userId") Long userId)
	throws ResourceNotFoundException{
		User user = userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("add")
	public User createUser(@Validated @RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="userId") Long userId,
			@Validated @RequestBody User userDetail)throws ResourceNotFoundException{
		User user = userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + userId));
		user.setUserName(userDetail.getUserName());
		user.setEmail(userDetail.getEmail());
		user.setPassword(userDetail.getPassword());
		final User updateUser =userRepo.save(user);
		return ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("delete/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value ="userId")Long userId)
	throws ResourceNotFoundException{
		User user=userRepo.findById(userId)
		.orElseThrow(()->new ResourceNotFoundException("User not found for this id :: " + userId));
		userRepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
	
}
