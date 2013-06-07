package br.brainshare.data;

import java.util.List;

import lib.exceptions.tagException;
import lib.exceptions.tagInexistenteException;
import br.brainshare.model.Tag;

public interface IDAOTag {

	public void save(Tag tag) throws tagException;
	public List<Tag> getTags() throws tagException;
	public Tag getTagInstance(Tag tag) throws tagException;
	public Tag searchTag(String nome) throws tagInexistenteException;

}
