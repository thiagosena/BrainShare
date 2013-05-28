package br.brainshare.business;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.data.IDAOQuestion;
import br.brainshare.data.mem.DAOMemoryQuestion;
import br.brainshare.model.QuestionBean;

public class ServiceQuestion implements IServiceQuestion{

	private static ServiceQuestion singleton = null;	
	private IDAOQuestion daoQuestion;

	public ServiceQuestion(){
		this.daoQuestion = new DAOMemoryQuestion();

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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean findQuestion(QuestionBean quest) {
		return this.daoQuestion.findQuestion(quest);
	}
	
	@Override
	public QuestionBean editQuestion(QuestionBean q) {
		return this.daoQuestion.getQuestionInstance(q);
	}
	

}
