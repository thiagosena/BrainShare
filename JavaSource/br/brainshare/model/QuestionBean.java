package br.brainshare.model;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import br.brainshare.business.IServiceQuestion;
import br.brainshare.business.ServiceQuestion;

@Entity
@Table(name = "question")
public class QuestionBean {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private String question;
	
	@NotNull
	private String title;
	
	@NotNull
	@Column(name = "data_cadastro")
	private Date dateRegister;
	
	@ManyToOne
	@JoinColumn(name = "id_tag", nullable = false)
	private TagBean tags;
	
	@OneToOne
	@JoinColumn(name = "id_user", nullable = true)
	private UserBean user;

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public TagBean getTags() {
		return tags;
	}

	public void setTags(TagBean tags) {
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}
	
	public String show(){
		IServiceQuestion service = new ServiceQuestion();
		QuestionBean q = null; 
		q = service.getQuestionInstance(title);
		HttpSession sessaoHttp = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
        sessaoHttp.setAttribute("questaoClicada", q);
		return "question";
	}
	
}
