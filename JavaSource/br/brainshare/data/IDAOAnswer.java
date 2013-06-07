package br.brainshare.data;

import java.util.List;

import lib.exceptions.RespostaException;
import br.brainshare.model.Answer;
import br.brainshare.model.Question;

public interface IDAOAnswer {
	
	public void save(Answer resposta) throws RespostaException;

	public List<Answer> listAll(Question question);
	
}
