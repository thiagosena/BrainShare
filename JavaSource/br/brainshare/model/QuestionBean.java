package br.brainshare.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	private TagBean tag;

	public TagBean getTag() {
		return tag;
	}

	public void setTag(TagBean tag) {
		this.tag = tag;
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
	
}
