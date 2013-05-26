package br.brainshare.data;

import java.util.List;

import br.brainshare.model.TagBean;

public interface IDAOTag {

	public void save(TagBean tag);
	public List<TagBean> getTags();

}
