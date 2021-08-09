package com.longnguyenquy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyenquy.dao.RoleDao;
import com.longnguyenquy.dao.UserDao;
import com.longnguyenquy.dto.PasswordChanger;
import com.longnguyenquy.dto.UserRegister;
import com.longnguyenquy.entity.Role;
import com.longnguyenquy.entity.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public List<User> getUsers(){
		
		return userDao.getUsers();
	}
	
	@Override
	@Transactional
	public User getUser(long id) {
		
		return userDao.getUser(id);
	}
	
	@Override
	@Transactional
	public List<Role> getRoles(){
		
		return roleDao.getRoles();
	}
	
	@Override
	@Transactional
	public void setRoles(User userDto) {
		
		User user = userDao.getUser(userDto.getId());
		
		Collection<Role> roles = userDto.getRoles();
		user.getRoles().clear();
		for(Role role: roles) {
			role = roleDao.findRoleByName(role.getName());
			user.getRoles().add(role);
		}
		
	}
	
	@Override
	@Transactional
	public User findByUserName(String userName) {
	
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public User currentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = userDao.findByUserName(username);
		
		return user;
		
	}
	
	@Override
	@Transactional
	public void save(UserRegister userDto) {
		User user = new User();
		
		 // assign user details to the user object
		user.setUserName(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setAddress(userDto.getAddress());

		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_CUSTOMER")));

		 // save user in the database
		userDao.save(user);
	}
	
	@Override
	@Transactional
	public void updateProfile(User userDto) {
		
		User user = userDao.getUser(userDto.getId());
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setAddress(userDto.getAddress());
		
		System.out.println(user);
		
		//userDao.save(user);
	}
	
	@Override
	@Transactional
	public boolean changePassword(PasswordChanger userDto) {
		
		System.out.println("inside changepassword");
		User user = currentUser();
		boolean check = passwordEncoder.matches(userDto.getOldPassword(), user.getPassword());
		if(check) {
			
			String newPassword = passwordEncoder.encode(userDto.getPassword());
			System.out.println(newPassword);
			user.setPassword(newPassword);
			
			return check;
		}
		return check;
	}
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
