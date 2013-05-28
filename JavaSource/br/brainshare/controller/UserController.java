package br.brainshare.controller;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.brainshare.business.IServiceUser;
import br.brainshare.business.ServiceUser;
import br.brainshare.model.UserBean;

@ManagedBean(name = "userController")
@RequestScoped  
public class UserController {

	private UserBean user;
	private IServiceUser service = new ServiceUser();
	private String passwordVal;

	public UserController(){
		user = new UserBean();
	}
	
	public String getPasswordVal() {
		return passwordVal;
	}

	public void setPasswordVal(String passwordVal) {
		this.passwordVal = passwordVal;
	}

	public String save(){
		if(!user.getPassword().equals(passwordVal)){
			FacesMessage msg = new FacesMessage("Senhas diferentes");
			FacesContext.getCurrentInstance().addMessage("erro", msg);
			return null;
		} else{
			user.setDateRegister(new Date());
			service.save(user);
			return "login";
		}
	}
	
	public String login(){
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
		
		if(service.findUser(user)){
			this.user = service.getUserInstance(user);
			HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);  
            sessaoHttp.setAttribute("usuarioLogado", user);  
			return "principal";
		} else {
			  /* Cria uma mensagem. */
		      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
		      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
		      FacesContext.getCurrentInstance().addMessage("erro", msg);
		      return null;
		}
	}
	
	//para recuperar o usuário:
	//usuario = (UserBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); 
	
	public String logout() {
		this.user = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
}
