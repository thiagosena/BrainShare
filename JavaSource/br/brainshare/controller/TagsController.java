package br.brainshare.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import lib.exceptions.tagException;
import lib.exceptions.tagInexistenteException;

import br.brainshare.business.IServiceTag;
import br.brainshare.business.ServiceTag;
import br.brainshare.model.TagBean;

@ManagedBean(name = "tagsController")
@RequestScoped 
public class TagsController {


	private TagBean tag;
	private List<TagBean> lista = null;
	private boolean list;

	private IServiceTag service = new ServiceTag();


	public TagsController() {
		tag = new TagBean();
		setList(false);
	}

	

	public String save() throws tagException{
		try{
			service.searchTag(tag.getName());
			FacesMessage msg = new FacesMessage("Essa tag já existe");
			FacesContext.getCurrentInstance().addMessage("erro", msg);
			return null;
		}
		catch(tagInexistenteException e){
			service.save(tag);
			return "index";
		}
	}


	public TagBean getTag() {
		return tag;
	}



	public void setTag(TagBean tag) {
		this.tag = tag;
	}
	
	public List<TagBean> getLista() throws tagException {
		if(lista == null){
			lista = service.getTags();
		}
		return lista;
	}



	public boolean getList() {
		return list;
	}



	public void setList(boolean list) {
		this.list = list;
	}
	
	public void truelist(){
		this.list = true;
		
	}
}	
