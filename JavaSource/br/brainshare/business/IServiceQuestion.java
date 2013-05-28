package br.brainshare.business;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.model.QuestionBean;

public interface IServiceQuestion {

	public boolean save(QuestionBean q) throws CampoVazioException;
	public List<QuestionBean> listAll();
	public boolean findQuestion(QuestionBean quest);
	public QuestionBean getQuestionInstance(QuestionBean question);
	public QuestionBean editQuestion(QuestionBean q);
	public void delete(QuestionBean q);
	
}
