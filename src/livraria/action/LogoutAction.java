package livraria.action;

import webf.action.Action;

public class LogoutAction extends Action {

	/**
	 * Faz o logout de um usuario logado
	 */
	@Override
	public void process() throws Exception {
		// Remove os atributos da sessao
		getSession().setAttribute("usuario", null);
		getSession().setAttribute("carrinho", null);
		
		redirect("usuario_deslogado.jsp");
	}
}
