package br.brainshare.business;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.model.Question;

public interface IServiceQuestion {

	public boolean save(Question q) throws CampoVazioException;
	
	public List<Question> listAll();
	
	public void delete(Question q);
	
	public boolean findQuestion(Question quest);
	
	public Question getQuestionInstance(Question question);
	
	public Question editQuestion(Question q);
		
	public Question getQuestionInstance(String title);
	
	public List<Question> findQuestionByTitleOrDescription(String title, String desc);
	
	public Integer countByAnswer(Integer id);
	
	public void update(Question q);
}
