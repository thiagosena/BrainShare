package br.brainshare.controller;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.brainshare.business.IServiceUser;
import br.brainshare.business.ServiceUser;
import br.brainshare.model.UserBean;

@ManagedBean(name = "userController")
@RequestScoped
public class UserController {

	private UserBean user = new UserBean();
	private IServiceUser service = new ServiceUser();
	private String passwordVal;
	
	public String getPasswordVal() {
		return passwordVal;
	}

	public void setPasswordVal(String passwordVal) {
		this.passwordVal = passwordVal;
	}

	public void save(){
		if(!user.getPassword().equals(passwordVal)){
			FacesMessage msg = new FacesMessage("Senhas diferentes");
			FacesContext.getCurrentInstance().addMessage("erro", msg);
		} else{
			user.setDateRegister(new Date());
			service.save(user);
		}
	}
	
	public String login(){
		if(service.findUser(user)){
			return "principal";
		} else {
			/* Cria uma mensagem. */
		      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
		      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
		      FacesContext.getCurrentInstance().addMessage("erro", msg);
		      return null;
		}
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
}
