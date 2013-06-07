package br.brainshare.data;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.model.Question;

public interface IDAOQuestion {
	
	public void save(Question question) throws CampoVazioException;
	
	public List<Question> listAll();
	
	public void delete(Question q);
	
	public boolean findQuestion(Question question);
	
	public Question getQuestionInstance(Question q);
		
	public Question editQuestion(Question q);
	
	public Question getQuestionInstance(String title);
	
	public List<Question> findQuestionByTitleOrDescription(String title, String desc);

	public Integer countByAnswer(Integer id);
	
	public void update(Question q);
}
