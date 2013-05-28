package br.brainshare.data.mem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lib.exceptions.RespostaException;
import br.brainshare.data.IDAOAnswer;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;

public class DAOMemoryAnswer implements IDAOAnswer {
	
	private Map<Integer, AnswerBean> resposta;
	
	public DAOMemoryAnswer(){
		this.resposta = new HashMap<Integer, AnswerBean>();
	}

	@Override
	public void save(AnswerBean resp) throws RespostaException {
		if(resp.getAnswer().isEmpty()){
			throw new RespostaException("Resposta vazia!");
		} else {
			this.resposta.put(resp.getQuestion().getId(), resp);
		}
	}

	@Override
	public List<AnswerBean> listAll(QuestionBean question) {
		// TODO Auto-generated method stub
		return null;
	}
}
