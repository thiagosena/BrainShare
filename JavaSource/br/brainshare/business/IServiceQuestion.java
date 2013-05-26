package br.brainshare.business;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.model.QuestionBean;

public interface IServiceQuestion {

	public boolean insertQuestion(QuestionBean q) throws CampoVazioException;
	public List<QuestionBean> findAll();
	public QuestionBean editQuestion(QuestionBean q);
	public void delete(Integer id);
	
}
