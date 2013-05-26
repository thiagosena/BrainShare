package br.brainshare.data.rdb;

import lib.exceptions.RespostaException;

import org.hibernate.Session;

import br.brainshare.data.IDAOAnswer;
import br.brainshare.model.AnswerBean;

public class DAOHibernateAnswer implements IDAOAnswer {

	private Session session;

	@Override
	public void save(AnswerBean resp)
			throws RespostaException {
		this.session.save(resp);
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
