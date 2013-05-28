package br.brainshare.controller;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import lib.exceptions.CampoVazioException;
import br.brainshare.business.IServiceQuestion;
import br.brainshare.business.IServiceTag;
import br.brainshare.business.ServiceQuestion;
import br.brainshare.business.ServiceTag;
import br.brainshare.model.QuestionBean;
import br.brainshare.model.TagBean;
import br.brainshare.model.UserBean;

@ManagedBean(name = "questionController")
@RequestScoped
public class QuestionController {


	private QuestionBean quest;
	private TagBean tagInstance;
	private IServiceQuestion service = new ServiceQuestion();
	private IServiceTag sTag = new ServiceTag();
	
	public QuestionController(){
		quest = new QuestionBean();
		tagInstance = new TagBean();
	}

	public void save() throws CampoVazioException{
		quest.setDateRegister(new Date());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		UserBean user = (UserBean) session.getAttribute("usuarioLogado");
		quest.setUser(user);
		tagInstance = sTag.getTagInstance(tagInstance);
		quest.setTags(tagInstance);
		
		service.save(quest);
	}

	public String find(){
		if(service.findQuestion(quest)){
			this.quest = service.getQuestionInstance(quest);
			return "success";
		} else {
			return "failed";
		}
	}

	public TagBean getTagInstance() {
		return tagInstance;
	}

	public void setTagInstance(TagBean tagInstance) {
		this.tagInstance = tagInstance;
	}

	public QuestionBean getQuest() {
		return quest;
	}

	public void setQuest(QuestionBean quest) {
		this.quest = quest;
	}

}