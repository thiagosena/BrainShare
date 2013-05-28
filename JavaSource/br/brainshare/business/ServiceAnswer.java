package br.brainshare.business;

import java.util.List;

import lib.exceptions.RespostaException;
import br.brainshare.data.IDAOAnswer;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;
import br.brainshare.util.DAOFactory;

public class ServiceAnswer implements IServiceAnswer {

	private IDAOAnswer daoAnswer;

	private static ServiceAnswer singleton = null;
	
	public ServiceAnswer(){
		this.daoAnswer = DAOFactory.createAnswerDAO();
	}
	
	public static ServiceAnswer getInstance(){
		if(singleton == null){
			singleton = new ServiceAnswer();
		}
		return singleton;
	}
	
	@Override
	public void save(AnswerBean resp) throws RespostaException {
		this.daoAnswer.save(resp);
	}

	@Override
	public List<AnswerBean> listAll(QuestionBean question) {
		return this.daoAnswer.listAll(question);
	}

}
