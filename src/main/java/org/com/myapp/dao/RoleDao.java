package org.com.myapp.dao;

import java.util.ArrayList;

import org.com.myapp.model.Role;

public interface RoleDao {

	Role findRoleById(int id);
	Role findRoleByName(String name);
	ArrayList<Role> getRoles();
}
