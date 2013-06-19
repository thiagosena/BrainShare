package br.brainshare.data;

import java.util.List;

import br.brainshare.model.User;

public interface IDAOUser {

	public List<User> listAll();
	public void save(User user);
	public boolean findUser(User user);
	public User getUserInstance(User user);
	public boolean findUserLogin(User user);
}
