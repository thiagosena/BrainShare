package br.brainshare.data.mem;

import java.util.ArrayList;
import java.util.List;

import br.brainshare.data.IDAOUser;
import br.brainshare.model.User;

public class DAOMemoryUser implements IDAOUser {

	private List<User> usuarios;

	public DAOMemoryUser() {
		this.usuarios = new ArrayList<User>();

		User usuario = new User();
		usuario.setUsername("renato");
		usuario.setPassword("123456");
		this.usuarios.add(usuario);
	}


	public List<User> listAll() {
		//System.out.println("Chegou no DAO, Uira");
		return usuarios;
	}


	public void save(User user) {

		if ((user.getUsername() == "") || (user.getPassword() == "")) {
			throw new NullPointerException();
		}
		else {
			this.usuarios.add(user);
		}
	}


	@Override
	public boolean findUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public User getUserInstance(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
