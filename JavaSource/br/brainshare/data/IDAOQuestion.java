package br.brainshare.data;

import java.util.List;

import lib.exceptions.CampoVazioException;
import br.brainshare.model.QuestionBean;

public interface IDAOQuestion {
	public void save(QuestionBean pergunta) throws CampoVazioException;
	public List<QuestionBean> findAll();
	public void delete(Integer id);
	public List<QuestionBean> list();
}
