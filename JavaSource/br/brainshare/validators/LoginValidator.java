package br.brainshare.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.brainshare.business.IServiceUser;
import br.brainshare.business.ServiceUser;
import br.brainshare.model.UserBean;

public class LoginValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		UserBean user = (UserBean) value;
		IServiceUser service = new ServiceUser();
		boolean validator = service.findUser(user);
		
		if(!validator){
			FacesMessage message = new FacesMessage();
			message.setDetail("Usuário " + user + " não existe!");
			message.setSummary("Login incorreto");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

}
