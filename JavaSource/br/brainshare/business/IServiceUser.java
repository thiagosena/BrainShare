package br.brainshare.business;

import java.util.List;

import br.brainshare.model.User;

public interface IServiceUser {

	public List<User> listAllUser();
	public boolean findUser(User user);
	public User getUserInstance(User user);
	public void save(User user);
	
}
