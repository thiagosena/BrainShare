package br.brainshare.data;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.model.QuestionBean;

public interface IDAOQuestion {
	
	public void save(QuestionBean question) throws CampoVazioException;
	
	public List<QuestionBean> listAll();
	
	public void delete(QuestionBean q);
	
	public boolean findQuestion(QuestionBean question);
	
	public QuestionBean getQuestionInstance(QuestionBean q);
		
	public QuestionBean editQuestion(QuestionBean q);
	
	public QuestionBean getQuestionInstance(String title);
	
	public List<QuestionBean> findQuestionByTitleOrDescription(String title, String desc);
}
