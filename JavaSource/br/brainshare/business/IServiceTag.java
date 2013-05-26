package br.brainshare.business;

import java.util.List;

import br.brainshare.model.TagBean;

public interface IServiceTag {

	public void save(TagBean tag);
	public List<TagBean> getTags();
	public boolean searchTag(String tagName);
}
