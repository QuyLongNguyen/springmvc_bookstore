package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.User;

public interface UserDao {
	
	List<User> getUsers();
	
	User getUser(long id);
	
    User findByUserName(String userName);
    
    User findByEmail(String email);
    
    User findByToken(String token);
     
    void save(User user);
    
}
