package com.bug.tracking.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.execption.UserEmailException;
import com.bug.tracking.execption.UserIdException;
import com.bug.tracking.model.User;
import com.bug.tracking.repository.UserRepo;
import com.bug.tracking.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepo userRepository;
	
	@Override
	public User saveOrUpdate(User user) {
		try{
			user.setId(user.getId());
			return userRepository.save(user);
		}catch(Exception ex) {
			throw new UserEmailException("User with email : "+user.getId()+"already exists");
		}
	}
	
	@Override
	public Optional<User> findUserById(long userId) {
		Optional<User> user=userRepository.findById(userId);
		if(user == null)
			throw new UserIdException("User Id " + userId +" does not exist");
		return user;
	}
	
	@Override
	public Iterable<User> findAllUser(){
		return userRepository.findAll();
	}
	
	@Override
	public void deleteUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user ==null)
			throw new UserIdException("User Id " + userId + "does not exist");
		userRepository.deleteById(user);
	}

}
