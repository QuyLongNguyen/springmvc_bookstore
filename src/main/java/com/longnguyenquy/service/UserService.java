package com.longnguyenquy.service;

import com.longnguyenquy.dto.*;
import com.longnguyenquy.entity.*;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);
    
    User currentUser();
    
    void save(UserRegister userDto);
    
   
}
