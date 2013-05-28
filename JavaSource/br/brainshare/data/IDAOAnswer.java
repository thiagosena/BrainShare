package br.brainshare.data;

import java.util.List;

import lib.exceptions.RespostaException;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;

public interface IDAOAnswer {
	
	public void save(AnswerBean resposta) throws RespostaException;

	public List<AnswerBean> listAll(QuestionBean question);
	
}
