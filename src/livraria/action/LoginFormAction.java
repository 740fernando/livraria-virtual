package livraria.action;

import webf.action.Action;

/**
 * Abre a tela de formulario de login
 * 
 * @author Fernando
 *
 */
public class LoginFormAction extends Action {

	@Override
	public void process() throws Exception {
		getSession().setAttribute("menuAtivo", "login");
		forward("login.jsp");
	}
}
