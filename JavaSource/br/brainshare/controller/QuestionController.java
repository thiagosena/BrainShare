package br.brainshare.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import lib.exceptions.CampoVazioException;
import lib.exceptions.tagException;
import lib.exceptions.tagInexistenteException;
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

	private List<QuestionBean> lista = null;
	private List<QuestionBean> listaTag = null;
	private List<QuestionBean> listByTitleOrDesc = null;

	private IServiceQuestion service = new ServiceQuestion();
	private IServiceTag sTag = new ServiceTag();

	private String titleOrDesc;

	public QuestionController() {
		quest = new QuestionBean();
		tagInstance = new TagBean();
	}

	public String save() throws CampoVazioException, tagInexistenteException, tagException {

		quest.setDateRegister(new Date());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		UserBean user = (UserBean) session.getAttribute("usuarioLogado");
		quest.setUser(user);
		quest.setCountAnswer(0);

		try {
			sTag.searchTag(tagInstance.getName());

		} catch (tagInexistenteException e) {
			FacesMessage msg = new FacesMessage(
					"Essa tag não existe, criei uma nova tag");
			FacesContext.getCurrentInstance().addMessage("erro", msg);
			return null;
		}
		tagInstance = sTag.getTagInstance(tagInstance);
		tagInstance.incrementQtd();
		System.out.println(tagInstance.getName());

		quest.setTags(tagInstance);

		service.save(quest);

		return "index";
	}

	public String find() {
		return "findQuestion";
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

	public List<QuestionBean> getLista() {
		if (lista == null) {
			lista = service.listAll();
		}
		return lista;
	}

	public List<QuestionBean> getListByTitleOrDesc() {
		if (listByTitleOrDesc == null) {
			listByTitleOrDesc = service.findQuestionByTitleOrDescription(
					titleOrDesc, titleOrDesc);
		}
		return listByTitleOrDesc;
	}

	public String getTitleOrDesc() {
		return titleOrDesc;
	}

	public void setTitleOrDesc(String titleOrDesc) {
		this.titleOrDesc = titleOrDesc;
	}

	public List<QuestionBean> getListaTag() {
		return listaTag;
	}

	public void setListaTag(List<QuestionBean> listaTag) {
		this.listaTag = listaTag;
	}
}