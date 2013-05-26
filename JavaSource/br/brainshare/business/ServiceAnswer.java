package br.brainshare.business;

import lib.exceptions.RespostaException;
import br.brainshare.data.IDAOAnswer;
import br.brainshare.model.AnswerBean;
import br.brainshare.util.DAOFactory;

public class ServiceAnswer implements IServiceAnswer {

	private IDAOAnswer daoResposta;

	private static ServiceAnswer singleton = null;
	
	public ServiceAnswer(){
		this.daoResposta = DAOFactory.createAnswerDAO();
	}
	
	public static ServiceAnswer getInstance(){
		if(singleton == null){
			singleton = new ServiceAnswer();
		}
		return singleton;
	}
	
	@Override
	public void save(AnswerBean resp) throws RespostaException {
		this.daoResposta.save(resp);
	}

}
