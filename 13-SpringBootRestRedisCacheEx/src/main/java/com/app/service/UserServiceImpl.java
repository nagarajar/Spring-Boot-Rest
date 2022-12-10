package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public String saveUser(User user) {
		user = repo.save(user);
		if(user.getId() != null){
			return "User "+user.getId() +" Created Sucessfully";
		}else {			
			return "User Failed To Create";
		}
	}

	@Override
	@Cacheable(value = "users",key = "#id")
	public User getOneUser(Integer id) {
		Optional<User> findById = repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	@CachePut(value = "users",key = "#id")
	public String updateUser(Integer id, User user) {
		if(repo.existsById(user.getId())) {
			repo.save(user);
			return "User "+user.getId() +" Updated Sucessfully";
		}else {			
			return "User Not Found";
		}
	}

	@Override
	@CacheEvict(value = "users", allEntries = true)
	public String deleteUser(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "User "+id +" Deleted Sucessfully";
		}else {			
			return "User Not Found";
		}
	}

}
