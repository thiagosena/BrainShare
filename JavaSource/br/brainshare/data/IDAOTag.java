package br.brainshare.data;

import java.util.List;

import lib.exceptions.tagException;
import lib.exceptions.tagInexistenteException;
import br.brainshare.model.TagBean;

public interface IDAOTag {

	public void save(TagBean tag) throws tagException;
	public List<TagBean> getTags() throws tagException;
	public TagBean getTagInstance(TagBean tag) throws tagException;
	public TagBean searchTag(String nome) throws tagInexistenteException;

}
