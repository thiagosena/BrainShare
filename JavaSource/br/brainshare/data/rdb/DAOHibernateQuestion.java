package br.brainshare.data.rdb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOQuestion;
import br.brainshare.model.QuestionBean;

public class DAOHibernateQuestion implements IDAOQuestion {

	private Session session;

	
	public List<QuestionBean> listAll() {
		Criteria lista = session.createCriteria(QuestionBean.class);

		@SuppressWarnings("unchecked")
		List<QuestionBean> questions = lista.list();
		return questions;
	}

	public void save(QuestionBean question) {
		this.session.save(question);
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public boolean findQuestion(QuestionBean question) {
		QuestionBean questionr = (QuestionBean) session.createCriteria(QuestionBean.class)
				.add(Restrictions.or(Restrictions.eq("title", question.getTitle()), Restrictions.eq("question", question.getQuestion())))
				.uniqueResult();
		
		if(questionr == null){
			return false;
		} else {
			return true;	
		}
	}

	@Override
	public QuestionBean getQuestionInstance(QuestionBean q) {
		QuestionBean questionInstance = (QuestionBean) session.createCriteria(QuestionBean.class)
				.add(Restrictions.or(Restrictions.eq("title", q.getTitle()), Restrictions.eq("question", q.getQuestion())))
				.uniqueResult();
		return questionInstance;
	}
	@Override
	public void delete(QuestionBean q) {
		this.session.delete(q);
	}

	@Override
	public QuestionBean getQuestionInstance(String title) {
		QuestionBean questionInstance = (QuestionBean) session.createCriteria(QuestionBean.class)
				.add(Restrictions.eq("title", title))
				.uniqueResult();
		return questionInstance;
	}




}
