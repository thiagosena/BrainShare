package br.brainshare.data;

import lib.exceptions.RespostaException;
import br.brainshare.model.AnswerBean;

public interface IDAOAnswer {
	
	public void save(AnswerBean resposta) throws RespostaException;
	
}
