package br.brainshare.business;

import java.util.List;

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

	public List<TagBean> getTags() {
		return this.daoTag.getTags();
	}

	@Override
	public void save(TagBean tag) {
		this.daoTag.save(tag);
	}

	@Override
	public TagBean getTagInstance(TagBean tagInstance) {
		return this.daoTag.getTagInstance(tagInstance);
	}

}
