package br.brainshare.controller;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.model.QuestionBean;

public class QuestionController {

	private QuestionBean questionUser;
	private Integer id;
	private boolean sucessoCadastroView = false;

	public QuestionController(){
		this.id = 1;
		this.questionUser = new QuestionBean();
	}

	public String adicionarPergunta() throws CampoVazioException{
		this.id++;
		this.questionUser = new QuestionBean();
		this.sucessoCadastroView = true;
		return "sucesso";
	}

	public List<QuestionBean> getPerguntas() {
		return null;  
	}  

	public void delete(){ 
	}  

	public QuestionBean getPerguntaUsuario() {
		return questionUser;
	}

	public void setPerguntaUsuario(QuestionBean perguntaUsuario) {
		this.questionUser = perguntaUsuario;
	}

	public boolean isSucessoCadastroView() {
		return sucessoCadastroView;
	}


}
