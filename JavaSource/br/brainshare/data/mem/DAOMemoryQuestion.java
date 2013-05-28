package br.brainshare.data.mem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lib.exceptions.CampoVazioException;
import br.brainshare.data.IDAOQuestion;
import br.brainshare.model.QuestionBean;

public class DAOMemoryQuestion implements IDAOQuestion{

	Map<Integer,QuestionBean> mapPerguntas;

	public DAOMemoryQuestion(){
		this.mapPerguntas = new HashMap<Integer,QuestionBean>();
	}

	public void save(QuestionBean pergunta) throws CampoVazioException {
		System.out.println(pergunta.getTitle());
		if(pergunta.getTitle()==""|| pergunta.getQuestion() ==""){
			throw new CampoVazioException();
		}
		else{
			mapPerguntas.put(pergunta.getId(), pergunta);
		}
	}

	public void delete(QuestionBean q) {  
		if (q.getId() != null)  
			mapPerguntas.remove(q.getId());  
	}  

	public List<QuestionBean> findAll() {  
		return new ArrayList<QuestionBean>(mapPerguntas.values());  
	}  

	public List<QuestionBean> list() {
		return new ArrayList<QuestionBean>(this.mapPerguntas.values());
	}

	@Override
	public List<QuestionBean> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findQuestion(QuestionBean question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QuestionBean getQuestionInstance(QuestionBean q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionBean getQuestionInstance(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionBean editQuestion(QuestionBean q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionBean> findQuestionByTitleOrDescription(String title,
			String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByAnswer(Integer q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QuestionBean q) {
		// TODO Auto-generated method stub
		
	}

}
