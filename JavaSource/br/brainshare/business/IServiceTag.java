package br.brainshare.business;

import java.util.List;

import lib.exceptions.tagException;
import lib.exceptions.tagInexistenteException;

import br.brainshare.model.Tag;

public interface IServiceTag {

	public void save(Tag tag) throws tagException;
	public List<Tag> getTags() throws tagException;
	public Tag getTagInstance(Tag tagInstance) throws tagException;
	public Tag searchTag(String nome) throws tagInexistenteException;
}
