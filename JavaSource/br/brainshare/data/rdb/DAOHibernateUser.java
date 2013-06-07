package br.brainshare.data.rdb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOUser;
import br.brainshare.model.User;

public class DAOHibernateUser implements IDAOUser {

	private Session session;

	@Override
	public List<User> listAll() {
		Criteria lista = session.createCriteria(User.class);

		@SuppressWarnings("unchecked")
		List<User> user = lista.list();
		return user;
	}

	@Override
	public void save(User user) {
		this.session.save(user);
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public boolean findUser(User user) {
		User userAdd = (User) session.createCriteria(User.class)
				.add(Restrictions.and(Restrictions.eq("username",user.getUsername()),Restrictions.eq("password",user.getPassword())))
	            .uniqueResult();
		
		if(userAdd == null){
			return false;
		} else {
			return true;	
		}
	}

	@Override
	public User getUserInstance(User user) {
		User userInstance = (User) session.createCriteria(User.class)
				.add(Restrictions.and(Restrictions.eq("username",user.getUsername()),Restrictions.eq("password",user.getPassword())))
	            .uniqueResult();
		return userInstance;
	}

}
