package br.brainshare.data.mem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lib.exceptions.CampoVazioException;
import br.brainshare.data.IDAOQuestion;
import br.brainshare.model.Question;

public class DAOMemoryQuestion implements IDAOQuestion{

	Map<Integer,Question> mapPerguntas;

	public DAOMemoryQuestion(){
		this.mapPerguntas = new HashMap<Integer,Question>();
	}

	public void save(Question pergunta) throws CampoVazioException {
		System.out.println(pergunta.getTitle());
		if(pergunta.getTitle()==""|| pergunta.getQuestion() ==""){
			throw new CampoVazioException();
		}
		else{
			mapPerguntas.put(pergunta.getId(), pergunta);
		}
	}

	public void delete(Question q) {  
		if (q.getId() != null)  
			mapPerguntas.remove(q.getId());  
	}  

	public List<Question> findAll() {  
		return new ArrayList<Question>(mapPerguntas.values());  
	}  

	public List<Question> list() {
		return new ArrayList<Question>(this.mapPerguntas.values());
	}

	@Override
	public List<Question> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findQuestion(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Question getQuestionInstance(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question getQuestionInstance(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question editQuestion(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> findQuestionByTitleOrDescription(String title,
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
	public void update(Question q) {
		// TODO Auto-generated method stub
		
	}

}
