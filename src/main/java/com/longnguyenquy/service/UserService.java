package com.longnguyenquy.service;

import com.longnguyenquy.dto.*;
import com.longnguyenquy.entity.*;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	List<User> getUsers();
	
	User getUser(long id);
	
	List<Role> getRoles();
	
	void setRoles(User userDto);
	
    User findByUserName(String userName);
    
    User findByEmail(String email);
    
    User findByToken(String token);
    
    User currentUser();
    
    void save(UserRegister userDto);
    
    void save(User user);
    
    void updateProfile(User userDto);
    
    boolean changePassword(PasswordChanger userDto);
    
    boolean resetPassword(PasswordChanger passwordChanger);
}
