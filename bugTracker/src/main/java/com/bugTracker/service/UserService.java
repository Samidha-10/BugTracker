package com.bug.tracking.service;

import java.util.Optional;

import com.bug.tracking.model.User;

public interface UserService {

	public User saveOrUpdate(User user);
	public Optional<User> findUserById(long userId);
	public Iterable<User> findAllUser();
	public void deleteUserById(Long userId);
}
