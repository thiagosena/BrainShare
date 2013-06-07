package br.brainshare.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import lib.exceptions.CampoVazioException;
import lib.exceptions.RespostaException;
import br.brainshare.business.IServiceAnswer;
import br.brainshare.business.IServiceQuestion;
import br.brainshare.business.ServiceAnswer;
import br.brainshare.business.ServiceQuestion;
import br.brainshare.model.Answer;
import br.brainshare.model.Question;
import br.brainshare.model.User;

@ManagedBean(name = "answerController")
@RequestScoped
public class AnswerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Answer answer;
	private List<Answer> lista = null;

	private IServiceAnswer service = new ServiceAnswer();

	private IServiceQuestion serviceQuestion = new ServiceQuestion();

	public AnswerController() {
		this.answer = new Answer();
	}
	
	public String save() throws RespostaException, CampoVazioException{
		this.answer.setDateRegister(new Date());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		User user = (User) session.getAttribute("usuarioLogado");
		Question question = (Question) session.getAttribute("questaoClicada");
		this.answer.setUser(user);
		this.answer.setQuestion(question);
		question.setCountAnswer(1);
		this.serviceQuestion.update(question);
		this.service.save(answer);
		return "index";
	}
	
	public List<Answer> getLista() {
		if(this.lista == null){
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Question question = (Question) session.getAttribute("questaoClicada");
			this.lista = this.service.listAll(question);
		}
		return this.lista;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
}
