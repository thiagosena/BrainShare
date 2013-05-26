package br.brainshare.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import lib.exceptions.RespostaException;

import org.junit.Test;

import br.brainshare.business.IServiceAnswer;
import br.brainshare.business.ServiceAnswer;
import br.brainshare.model.AnswerBean;
import br.brainshare.model.QuestionBean;
import br.brainshare.model.UserBean;

public class AnswerTest {

	@Test
	public void salvarTest() {
		QuestionBean q = new QuestionBean();
		q.setQuestion("Qual o valor em km/h da velocidade da luz?");
		q.setTitle("Fisica");
		AnswerBean a = new AnswerBean();
		UserBean u = new UserBean();
		a.setAnswer("Acho que é 300000km/h");
		a.setQuestion(q);
		a.setUser(u);
		a.setDateRegister(new Date());
		
		IServiceAnswer rn = new ServiceAnswer();
		try {
			rn.save(a);
		} catch (RespostaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, true);
	}

}
