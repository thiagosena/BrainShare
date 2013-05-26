package br.brainshare.data;

import java.util.List;

import br.brainshare.model.UserBean;

public interface IDAOUser {

	public List<UserBean> listAll();
	public void save(UserBean user);
	public boolean findUser(UserBean user);
	
}
