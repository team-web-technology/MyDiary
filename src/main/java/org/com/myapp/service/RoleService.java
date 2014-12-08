package org.com.myapp.service;

import java.util.ArrayList;

import org.com.myapp.model.Role;

public interface RoleService {

	Role findRoleById(int id);
	public Role findRoleByName(String name);
	public ArrayList<Role> getRoles();
}
