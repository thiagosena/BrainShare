package br.brainshare.business;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.data.IDAOQuestion;
import br.brainshare.model.QuestionBean;
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
	public List<QuestionBean> listAll() {
		return this.daoQuestion.listAll();

	}

	@Override
	public void delete(QuestionBean q) {
		this.daoQuestion.delete(q);

	}
	
	@Override
	public boolean save(QuestionBean q) throws CampoVazioException {
		this.daoQuestion.save(q);
		return true;
	}

	@Override
	public QuestionBean getQuestionInstance(QuestionBean question) {
		return this.daoQuestion.getQuestionInstance(question);
	}
	
	@Override
	public boolean findQuestion(QuestionBean quest) {
		return this.daoQuestion.findQuestion(quest);
	}
	
	@Override
	public QuestionBean editQuestion(QuestionBean q) {
		return null;
	}
	@Override
	public QuestionBean getQuestionInstance(String title) {
		return this.daoQuestion.getQuestionInstance(title);
	}
	@Override
	public List<QuestionBean> findQuestionByTitleOrDescription(String title,
			String desc) {
		return this.daoQuestion.findQuestionByTitleOrDescription(title, desc);
	}
	@Override
	public Integer countByAnswer(Integer id) {
		return this.daoQuestion.countByAnswer(id);
	}
	@Override
	public void update(QuestionBean q) {
		this.daoQuestion.update(q);
	}
	

}
