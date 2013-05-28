package br.brainshare.data.mem;

import java.util.ArrayList;
import java.util.List;

import br.brainshare.data.IDAOUser;
import br.brainshare.model.UserBean;

public class DAOMemoryUser implements IDAOUser {

	private List<UserBean> usuarios;

	public DAOMemoryUser() {
		this.usuarios = new ArrayList<UserBean>();

		UserBean usuario = new UserBean();
		usuario.setUsername("renato");
		usuario.setPassword("123456");
		this.usuarios.add(usuario);
	}


	public List<UserBean> listAll() {
		//System.out.println("Chegou no DAO, Uira");
		return usuarios;
	}


	public void save(UserBean user) {

		if ((user.getUsername() == "") || (user.getPassword() == "")) {
			throw new NullPointerException();
		}
		else {
			this.usuarios.add(user);
		}
	}


	@Override
	public boolean findUser(UserBean user) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public UserBean getUserInstance(UserBean user) {
		// TODO Auto-generated method stub
		return null;
	}
}
