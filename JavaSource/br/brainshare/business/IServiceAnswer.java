package br.brainshare.business;

import java.util.List;

import lib.exceptions.RespostaException;
import br.brainshare.model.Answer;
import br.brainshare.model.Question;

public interface IServiceAnswer {
	
	public void save(Answer resp) throws RespostaException;

	public List<Answer> listAll(Question question);
	
}
