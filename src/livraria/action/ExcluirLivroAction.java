package livraria.action;

import livraria.service.LivroService;
import webf.action.Action;

public class ExcluirLivroAction extends Action {

	public ExcluirLivroAction() {
	}
	@Override
	public void process() throws Exception {
		String livroId = this.getRequest().getParameter("id");
		
		LivroService livroService = serviceFactory.getService(LivroService.class);
		livroService.excluir(Integer.parseInt(livroId));
		
		redirect("admin/ListarLivros.action");
	}
}
