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

	public void delete(Integer id) {  
		if (id != null)  
			mapPerguntas.remove(id);  
	}  

	public List<QuestionBean> findAll() {  
		return new ArrayList<QuestionBean>(mapPerguntas.values());  
	}  

	public List<QuestionBean> list() {
		return new ArrayList<QuestionBean>(this.mapPerguntas.values());
	}

}
