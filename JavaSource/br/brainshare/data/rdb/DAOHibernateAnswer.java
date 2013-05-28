package br.brainshare.data.rdb;

import java.util.List;

import lib.exceptions.RespostaException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOAnswer;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;

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

	@Override
	public List<AnswerBean> listAll(QuestionBean question) {
		Criteria lista = session.createCriteria(AnswerBean.class);
		Criteria lista2 = lista.createCriteria("question");
		lista2.add(Restrictions.eq("id", question.getId()));
		
		@SuppressWarnings("unchecked")
		List<AnswerBean> answer = lista.list();
		return answer;
	}
}
