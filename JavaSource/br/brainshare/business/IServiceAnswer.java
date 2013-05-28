package br.brainshare.business;

import java.util.List;

import lib.exceptions.RespostaException;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;

public interface IServiceAnswer {
	
	public void save(AnswerBean resp) throws RespostaException;

	public List<AnswerBean> listAll(QuestionBean question);
	
}
