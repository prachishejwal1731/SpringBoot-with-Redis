package com.api.redis.dao;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.api.redis.models.*;

@Repository
public class UserDao {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	private static final String KEY="USER";
	
	//SAVE USER
	public User save(User user) {
		redisTemplate.opsForHash().put(KEY,user.getUserId(),user);
		return user;
	}
	
	public User get(String userId) {
		return (User) redisTemplate.opsForHash().get(KEY,userId);
	}
	
	//find all
	public Map<Object,Object>  findAll(){
		return redisTemplate.opsForHash().entries(KEY);
	}
	
	//delete
	public void delete(String userId) {
		 redisTemplate.opsForHash().delete(KEY,userId);

	}
}
