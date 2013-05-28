package br.brainshare.business;

import java.util.List;

import lib.exceptions.tagException;
import lib.exceptions.tagInexistenteException;
import br.brainshare.data.IDAOTag;
import br.brainshare.model.TagBean;
import br.brainshare.util.DAOFactory;

public class ServiceTag implements IServiceTag {
	
	IDAOTag daoTag = DAOFactory.createTagDAO();
	
	private static ServiceTag singleton = null;
	
	public static ServiceTag getInstance(){
		if (singleton == null) {
			singleton = new ServiceTag();
		}
		return singleton;
	}

	public List<TagBean> getTags() throws tagException {
		return this.daoTag.getTags();
	}

	@Override
	public void save(TagBean tag) throws tagException {
		this.daoTag.save(tag);
	}

	@Override
	public TagBean getTagInstance(TagBean tagInstance) throws tagException {
		return this.daoTag.getTagInstance(tagInstance);
	}
	
	@Override
	public TagBean searchTag(String nome) throws tagInexistenteException {
		if(this.daoTag.searchTag(nome)!= null){
			return this.daoTag.searchTag(nome);
		}else{
			throw new tagInexistenteException();
		}
	}

}
