package br.brainshare.data.mem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lib.exceptions.RespostaException;
import br.brainshare.data.IDAOAnswer;
import br.brainshare.model.Answer;
import br.brainshare.model.Question;

public class DAOMemoryAnswer implements IDAOAnswer {
	
	private Map<Integer, Answer> resposta;
	
	public DAOMemoryAnswer(){
		this.resposta = new HashMap<Integer, Answer>();
	}

	@Override
	public void save(Answer resp) throws RespostaException {
		if(resp.getAnswer().isEmpty()){
			throw new RespostaException("Resposta vazia!");
		} else {
			this.resposta.put(resp.getQuestion().getId(), resp);
		}
	}

	@Override
	public List<Answer> listAll(Question question) {
		// TODO Auto-generated method stub
		return null;
	}
}
