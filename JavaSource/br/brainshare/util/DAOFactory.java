package br.brainshare.util;

import br.brainshare.HibernateUtil;
import br.brainshare.data.IDAOAnswer;
import br.brainshare.data.IDAOUser;
import br.brainshare.data.rdb.DAOHibernateAnswer;
import br.brainshare.data.rdb.DAOHibernateUser;

public class DAOFactory {
	
	public static IDAOAnswer createAnswerDAO(){
		DAOHibernateAnswer answer = new DAOHibernateAnswer();
		answer.setSession(HibernateUtil.getSession()
				.getCurrentSession());
		return answer;
	}

	public static IDAOUser createUserDAO() {
		DAOHibernateUser user = new DAOHibernateUser();
		user.setSession(HibernateUtil.getSession()
				.getCurrentSession());
		return user;
	}
}
