package br.brainshare.data.rdb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOUser;
import br.brainshare.model.UserBean;

public class DAOHibernateUser implements IDAOUser {

	private Session session;

	@Override
	public List<UserBean> listAll() {
		Criteria lista = session.createCriteria(UserBean.class);

		@SuppressWarnings("unchecked")
		List<UserBean> user = lista.list();
		return user;
	}

	@Override
	public void save(UserBean user) {
		this.session.save(user);
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public boolean findUser(UserBean user) {
		UserBean userAdd = (UserBean) session.createCriteria(UserBean.class)
				.add(Restrictions.and(Restrictions.eq("username",user.getUsername()),Restrictions.eq("password",user.getPassword())))
	            .uniqueResult();
		
		if(userAdd == null){
			return false;
		} else {
			return true;	
		}
	}

	@Override
	public UserBean getUserInstance(UserBean user) {
		UserBean userInstance = (UserBean) session.createCriteria(UserBean.class)
				.add(Restrictions.and(Restrictions.eq("username",user.getUsername()),Restrictions.eq("password",user.getPassword())))
	            .uniqueResult();
		return userInstance;
	}

}
