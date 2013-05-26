package br.brainshare.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.brainshare.HibernateUtil;
import br.brainshare.model.QuestionBean;

public class QuestionTest {
	
	private static Session session;
	private static Transaction transaction;
	
	@BeforeClass
	public static void openConnection(){
		session = HibernateUtil.getSession().getCurrentSession();
		transaction = session.beginTransaction();
	}
	
	@AfterClass
	public static void closeConnection(){
		
		try {
			transaction.commit();
		} catch (Throwable e) {
			System.err.println("Deu problema no commit: " + e.getMessage());
		}finally{
			try {
				if (session.isOpen()) {
					session.close();
				}
			} catch (Exception e2) {
				System.err.println("Deu problema ao fechar uma conexão: " + e2.getMessage());
			}
		}
	}
	
	@Before
	public void setup(){
		QuestionBean q1 = new QuestionBean();
		q1.setQuestion("o que é hibernate?");
		q1.setTitle("informatica");
		
		session.save(q1);
		
	}
	
	@After
	public void cleanDados(){
		Criteria lista = session.createCriteria(QuestionBean.class);
		@SuppressWarnings("unchecked")
		List<QuestionBean> questions = lista.list();
		
		for (QuestionBean question : questions) {
			session.delete(question);
		}
	}
	
	@Test
	public void saveQuestionTest(){
		Query find = pesquisar("inf");
		
		QuestionBean qFind = (QuestionBean) find.uniqueResult();
		assertEquals("informatica", qFind.getTitle());
	}
	
	@Test
	public void listQuestionTest(){
		Criteria lista = session.createCriteria(QuestionBean.class);
		@SuppressWarnings("unchecked")
		List<QuestionBean> questions = lista.list();
		
		assertEquals(5, questions.size());
	}
	
	@Test
	public void alterQuestionTest(){
		Query find = pesquisar("futebol");
		QuestionBean qAlterado = (QuestionBean) find.uniqueResult();
		qAlterado.setQuestion("Questão de futebol alterada!");
		session.update(qAlterado);
		
		qAlterado = (QuestionBean) find.uniqueResult();
		assertEquals("Questão de futebol alterada!", qAlterado.getQuestion());
	}
	
	@Test
	public void deleteQuestionTest(){
		Query find = pesquisar("portugues");
		QuestionBean qDeletado = (QuestionBean) find.uniqueResult();
		session.delete(qDeletado);
		
		qDeletado = (QuestionBean) find.uniqueResult();
		
		assertNull(qDeletado);
		
	}
	
	private Query pesquisar(String title) {
		String sql = "from QuestionBean q where q.title like :title";
		Query find = session.createQuery(sql);
		find.setString("title", "%"+title+"%");
		return find;
	}
}
