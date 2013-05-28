package br.brainshare.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import lib.exceptions.RespostaException;
import br.brainshare.business.IServiceAnswer;
import br.brainshare.business.ServiceAnswer;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;
import br.brainshare.model.UserBean;

@ManagedBean(name = "answerController")
@RequestScoped
public class AnswerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AnswerBean answer;
	private List<AnswerBean> lista = null;

	private IServiceAnswer service = new ServiceAnswer();

	public AnswerController() {
		this.answer = new AnswerBean();
	}
	
	public String save() throws RespostaException{
		this.answer.setDateRegister(new Date());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		UserBean user = (UserBean) session.getAttribute("usuarioLogado");
		QuestionBean question = (QuestionBean) session.getAttribute("questaoClicada");
		this.answer.setUser(user);
		this.answer.setQuestion(question);
		this.service.save(answer);
		return "index";
	}
	
	public List<AnswerBean> getLista() {
		if(this.lista == null){
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			QuestionBean question = (QuestionBean) session.getAttribute("questaoClicada");
			this.lista = this.service.listAll(question);
		}
		return this.lista;
	}

	public AnswerBean getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerBean answer) {
		this.answer = answer;
	}
	
}
