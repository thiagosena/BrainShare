package br.brainshare.data.rdb;

import java.util.List;

import lib.exceptions.RespostaException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOAnswer;
import br.brainshare.model.Answer;
import br.brainshare.model.Question;

public class DAOHibernateAnswer implements IDAOAnswer {

	private Session session;

	@Override
	public void save(Answer resp)
			throws RespostaException {
		
		this.session.save(resp);
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<Answer> listAll(Question question) {
		Criteria lista = session.createCriteria(Answer.class);
		Criteria lista2 = lista.createCriteria("question");
		lista2.add(Restrictions.eq("id", question.getId()));
		
		@SuppressWarnings("unchecked")
		List<Answer> answer = lista.list();
		return answer;
	}
}
