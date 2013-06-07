package br.brainshare.data.rdb;

import java.util.List;

import lib.exceptions.tagInexistenteException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.brainshare.data.IDAOTag;
import br.brainshare.model.Tag;

public class DAOHibernateTag implements IDAOTag {

	private Session session;

	@Override
	public void save(Tag tag) {
		this.session.save(tag);
	}

	@Override
	public List<Tag> getTags() {
		Criteria lista = session.createCriteria(Tag.class);

		@SuppressWarnings("unchecked")
		List<Tag> tags = lista.list();

		return tags;
	}

	@Override
	public Tag getTagInstance(Tag tag) {
		Tag questionInstance = (Tag) session
				.createCriteria(Tag.class)
				.add(Restrictions.eq("name", tag.getName())).uniqueResult();
		return questionInstance;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Tag searchTag(String nome) throws tagInexistenteException {
		try {
			Tag tag = (Tag) session.createCriteria(Tag.class)
					.add(Restrictions.eq("name", nome)).uniqueResult();

			return tag;
		} catch (Exception e) {
			return null;
		}
	}

}
