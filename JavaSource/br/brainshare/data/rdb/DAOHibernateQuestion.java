package br.brainshare.data.rdb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOQuestion;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;

public class DAOHibernateQuestion implements IDAOQuestion {

	private Session session;

	@Override
	public List<QuestionBean> listAll() {
		Criteria lista = session.createCriteria(QuestionBean.class);

		@SuppressWarnings("unchecked")
		List<QuestionBean> questions = lista.list();
		return questions;
	}

	@Override
	public void save(QuestionBean question) {
		this.session.save(question);
	}

	@Override
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionBean> findQuestionByTitleOrDescription(String title, String desc){
		List<QuestionBean> lista = session.createCriteria(QuestionBean.class)
					.add(Restrictions.or(
							Restrictions.like("title", "%"+title+"%"),
							Restrictions.like("question", "%"+desc+"%")
					)).list();
		
		System.out.println("lista: "+lista.get(0).getTitle());
			 
		return lista;
	}
	
	@Override
	public Integer countByAnswer(Integer id){
		Long teste = id.longValue();
		Integer numberAnswer = (Integer) session.createCriteria(AnswerBean.class)
				.add(Restrictions.eq("id", teste))
				.setProjection(Projections.rowCount()).uniqueResult();
		return numberAnswer;
		
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public QuestionBean editQuestion(QuestionBean q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QuestionBean q) {
		this.session.update(q);
	}


}
