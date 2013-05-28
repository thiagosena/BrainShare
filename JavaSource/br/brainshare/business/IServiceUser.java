package br.brainshare.business;

import java.util.List;

import br.brainshare.model.UserBean;

public interface IServiceUser {

	public List<UserBean> listAllUser();
	public boolean findUser(UserBean user);
	public UserBean getUserInstance(UserBean user);
	public void save(UserBean user);
	
}
