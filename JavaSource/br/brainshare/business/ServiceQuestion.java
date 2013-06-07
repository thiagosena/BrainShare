package br.brainshare.business;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.data.IDAOQuestion;
import br.brainshare.model.Question;
import br.brainshare.util.DAOFactory;

public class ServiceQuestion implements IServiceQuestion{

	private static ServiceQuestion singleton = null;	
	private IDAOQuestion daoQuestion;

	public ServiceQuestion(){
		this.daoQuestion = DAOFactory.createQuestionDAO();

	}
	public static ServiceQuestion getInstance(){
		if(singleton==null){
			singleton = new ServiceQuestion();
		}
		return singleton;
	}

	@Override
	public List<Question> listAll() {
		return this.daoQuestion.listAll();

	}

	@Override
	public void delete(Question q) {
		this.daoQuestion.delete(q);

	}
	
	@Override
	public boolean save(Question q) throws CampoVazioException {
		this.daoQuestion.save(q);
		return true;
	}

	@Override
	public Question getQuestionInstance(Question question) {
		return this.daoQuestion.getQuestionInstance(question);
	}
	
	@Override
	public boolean findQuestion(Question quest) {
		return this.daoQuestion.findQuestion(quest);
	}
	
	@Override
	public Question editQuestion(Question q) {
		return null;
	}
	@Override
	public Question getQuestionInstance(String title) {
		return this.daoQuestion.getQuestionInstance(title);
	}
	@Override
	public List<Question> findQuestionByTitleOrDescription(String title,
			String desc) {
		return this.daoQuestion.findQuestionByTitleOrDescription(title, desc);
	}
	@Override
	public Integer countByAnswer(Integer id) {
		return this.daoQuestion.countByAnswer(id);
	}
	@Override
	public void update(Question q) {
		this.daoQuestion.update(q);
	}
	

}
