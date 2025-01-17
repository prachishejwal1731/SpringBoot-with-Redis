package com.api.redis.controllers;

import java.util.Map;
import java.util.UUID;

import com.api.redis.models.*;
import com.api.redis.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControllers {
	
	@Autowired
	private UserDao userDao;
	
     @PostMapping()
     public User createUser(@RequestBody User user ) {
    	user.setUserId(UUID.randomUUID().toString());
    	return userDao.save(user);
     }
     
     //get user 
     @GetMapping("/{userId}")
     public User getUser(@PathVariable("userId") String userId) {
    	 return userDao.get(userId);
     }
     
     //find all
     
     @GetMapping
     public Map<Object,Object> getAll(){
    	 return userDao.findAll();
     }

     @DeleteMapping("/{userId}")
     public void deleteUser(@PathVariable("userId") String userId) {
    	 userDao.delete(userId);
     }

}

