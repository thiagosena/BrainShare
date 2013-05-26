package br.brainshare.business;

import java.util.List;

import br.brainshare.data.IDAOUser;
import br.brainshare.model.UserBean;
import br.brainshare.util.DAOFactory;

public class ServiceUser implements IServiceUser{

	
	private static ServiceUser singleton = null;
	private IDAOUser daoUsuario;
	
	public ServiceUser(){
		this.daoUsuario = DAOFactory.createUserDAO();
	}
	
	public static ServiceUser getInstance() {
		if (singleton == null) {
			singleton = new ServiceUser();
		}
		return singleton;
	}
	
	
	public List<UserBean> listAllUser() {
		return this.daoUsuario.listAll();
	}

	
	public void save(UserBean user) {
		this.daoUsuario.save(user);
	}

	@Override
	public boolean findUser(UserBean user) {
		return this.daoUsuario.findUser(user); 
	}	
}
