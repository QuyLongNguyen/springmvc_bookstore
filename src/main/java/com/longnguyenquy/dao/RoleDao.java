package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.Role;

public interface RoleDao {

	public List<Role> getRoles();
	
	public Role findRoleByName(String theRoleName);
	
	
	
}
