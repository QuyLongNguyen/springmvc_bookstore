package com.longnguyenquy.dao;

import com.longnguyenquy.entity.User;

public interface UserDao {
	
	User getUser(long id);
	
    User findByUserName(String userName);
    
    void save(User user);
    
}
