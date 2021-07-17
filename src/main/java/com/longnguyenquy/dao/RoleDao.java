package com.longnguyenquy.dao;

import com.longnguyenquy.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
