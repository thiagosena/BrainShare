package br.brainshare.data.mem;

import java.util.ArrayList;
import java.util.List;

import lib.exceptions.tagInexistenteException;

import br.brainshare.data.IDAOTag;
import br.brainshare.model.Tag;

public class DAOMemoryTag implements IDAOTag {
	
	private List<Tag> tags = new ArrayList<Tag>();

	public DAOMemoryTag() {
		Tag t1 = new Tag();
		t1.setName("Programação Distribuída");
		
		Tag t2 = new Tag();
		t2.setName("Programação Distribuída");
		
		Tag t3 = new Tag();
		t3.setName("Programação Distribuída");
		
		Tag t4 = new Tag();
		t4.setName("Programação Distribuída");
		
		this.tags.add(t1);
		this.tags.add(t2);
		this.tags.add(t3);
		this.tags.add(t4);
	}

	public List<Tag> getTags() {
		return tags;
	}

	@Override
	public void save(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tag getTagInstance(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag searchTag(String nome) throws tagInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

}
