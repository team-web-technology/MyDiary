package org.com.myapp.service;

import java.util.ArrayList;

import org.com.myapp.dao.RoleDao;
import org.com.myapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	
	
	
	@Override
	@Transactional
	public Role findRoleById(int id) {
		Role r = (Role)roleDao.findRoleById(id);
		return r;
	}

	@Override
	@Transactional
	public Role findRoleByName(String name) {
		Role r = (Role)roleDao.findRoleByName(name);
		return r;
	}

	@Override
	@Transactional
	public ArrayList<Role> getRoles() {

		
		return null;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	
	
}
