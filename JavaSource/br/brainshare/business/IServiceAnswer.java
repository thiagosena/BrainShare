package br.brainshare.business;

import lib.exceptions.RespostaException;
import br.brainshare.model.AnswerBean;

public interface IServiceAnswer {
	
	public void save(AnswerBean resp) throws RespostaException;
	
}
