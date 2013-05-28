package br.brainshare.data.mem;

import java.util.ArrayList;
import java.util.List;

import lib.exceptions.tagInexistenteException;

import br.brainshare.data.IDAOTag;
import br.brainshare.model.TagBean;

public class DAOMemoryTag implements IDAOTag {
	
	private List<TagBean> tags = new ArrayList<TagBean>();

	public DAOMemoryTag() {
		TagBean t1 = new TagBean();
		t1.setName("Programação Distribuída");
		
		TagBean t2 = new TagBean();
		t2.setName("Programação Distribuída");
		
		TagBean t3 = new TagBean();
		t3.setName("Programação Distribuída");
		
		TagBean t4 = new TagBean();
		t4.setName("Programação Distribuída");
		
		this.tags.add(t1);
		this.tags.add(t2);
		this.tags.add(t3);
		this.tags.add(t4);
	}

	public List<TagBean> getTags() {
		return tags;
	}

	@Override
	public void save(TagBean tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagBean getTagInstance(TagBean tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagBean searchTag(String nome) throws tagInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

}
