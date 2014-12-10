package org.com.myapp.dao;

import java.util.ArrayList;

import org.com.myapp.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findRoleById(int id) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Role r = (Role) session
				.createSQLQuery(
						"select r.* from userprofile u,role r where u.IdRole = r.idauthority and u.id = ?")
				.addEntity(Role.class).setParameter(0, id).uniqueResult();
		session.getTransaction().commit();
		return r;
	}

	@Override
	public Role findRoleByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Role r = (Role) session.createCriteria(Role.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
		session.getTransaction().commit();
		return r;
	}

	@Override
	public ArrayList<Role> getRoles() {

		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
