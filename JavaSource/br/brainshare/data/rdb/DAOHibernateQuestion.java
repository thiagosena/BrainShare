package br.brainshare.data.rdb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOQuestion;
import br.brainshare.model.Answer;
import br.brainshare.model.Question;

public class DAOHibernateQuestion implements IDAOQuestion {

	private Session session;

	@Override
	public List<Question> listAll() {
		Criteria lista = session.createCriteria(Question.class);

		@SuppressWarnings("unchecked")
		List<Question> questions = lista.list();
		return questions;
	}

	@Override
	public void save(Question question) {
		this.session.save(question);
	}

	@Override
	public boolean findQuestion(Question question) {
		Question questionr = (Question) session.createCriteria(Question.class)
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
	public List<Question> findQuestionByTitleOrDescription(String title, String desc){
		List<Question> lista = session.createCriteria(Question.class)
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
		Integer numberAnswer = (Integer) session.createCriteria(Answer.class)
				.add(Restrictions.eq("id", teste))
				.setProjection(Projections.rowCount()).uniqueResult();
		return numberAnswer;
		
	}

	@Override
	public Question getQuestionInstance(Question q) {
		Question questionInstance = (Question) session.createCriteria(Question.class)
				.add(Restrictions.or(Restrictions.eq("title", q.getTitle()), Restrictions.eq("question", q.getQuestion())))
				.uniqueResult();
		return questionInstance;
	}
	@Override
	public void delete(Question q) {
		this.session.delete(q);
	}

	@Override
	public Question getQuestionInstance(String title) {
		Question questionInstance = (Question) session.createCriteria(Question.class)
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
	public Question editQuestion(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Question q) {
		this.session.update(q);
	}


}
