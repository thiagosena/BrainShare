package br.brainshare.business;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.data.IDAOQuestion;
import br.brainshare.data.mem.DAOMemoryQuestion;
import br.brainshare.model.QuestionBean;

public class ServiceQuestion implements IServiceQuestion{

	private static ServiceQuestion singleton = null;	
	private IDAOQuestion daopergunta;

	public ServiceQuestion(){
		this.daopergunta = new DAOMemoryQuestion();

	}
	public static ServiceQuestion getInstance(){
		if(singleton==null){
			singleton = new ServiceQuestion();
		}
		return singleton;
	}


	public boolean insertQuestion(QuestionBean pergunta) throws CampoVazioException {
		this.daopergunta.save(pergunta);
		return true;

	}
	
	public List<QuestionBean> findAll() {
		return this.daopergunta.findAll();

	}

	public void delete(Integer id) {
		this.daopergunta.delete(id);

	}
	@Override
	public QuestionBean editQuestion(QuestionBean q) {
		// TODO Auto-generated method stub
		return null;
	}

}
