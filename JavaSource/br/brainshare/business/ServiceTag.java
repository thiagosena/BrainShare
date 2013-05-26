package br.brainshare.business;

import java.util.List;

import br.brainshare.data.IDAOTag;
import br.brainshare.data.mem.DAOMemoryTag;
import br.brainshare.model.TagBean;

public class ServiceTag implements IServiceTag {
	
	IDAOTag dao = new DAOMemoryTag();
	
	private static ServiceTag singleton = null;
	
	public static ServiceTag getInstance(){
		if (singleton == null) {
			singleton = new ServiceTag();
		}
		return singleton;
	}

	public List<TagBean> getTags() {
		return this.dao.getTags();
	}
	
	public boolean searchTag(String tagName) {
		List<TagBean>tags = this.getTags();
		boolean result = false;
//		Itera a lista a procura de uma tag com o nome passado por parametro 
		for (int i = 0; i < tags.size(); i++) {
			if (tags.get(i).getName().contains(tagName)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public void save(TagBean tag) {
		// TODO Auto-generated method stub
		
	}

}
