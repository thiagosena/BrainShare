package br.brainshare.data.rdb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOTag;
import br.brainshare.model.TagBean;

public class DAOHibernateTag implements IDAOTag {

	private Session session;
	
	@Override
	public void save(TagBean tag) {
		this.session.save(tag);
	}

	@Override
	public List<TagBean> getTags() {
		Criteria lista = session.createCriteria(TagBean.class);
		
		@SuppressWarnings("unchecked")
		List<TagBean> tags = lista.list();
		
		return tags;
	}

	@Override
	public TagBean getTagInstance(TagBean tag) {
		TagBean questionInstance = (TagBean) session.createCriteria(TagBean.class)
				.add(Restrictions.eq("name", tag.getName()))
				.uniqueResult();
		return questionInstance;
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


}
