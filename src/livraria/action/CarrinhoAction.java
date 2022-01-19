package livraria.action;

import javax.persistence.Cache;

import livraria.entity.Livro;
import livraria.helper.Carrinho;
import livraria.service.LivroService;
import webf.action.Action;
/*
 * Adiciona um livro no carrinho
 */
public class CarrinhoAction extends Action {

	public CarrinhoAction() {
	}

	@Override
	public void process() throws Exception {
		LivroService livroService = (LivroService)this.serviceFactory.getService(LivroService.class);
		Carrinho carrinho = (Carrinho)this.getSession().getAttribute("carrinho");
		if(carrinho == null) {
			carrinho = new Carrinho();
			this.getSession().setAttribute("carrinho", carrinho);
		}
		
		String op = this.getRequest().getParameter("op");
		String livroId = this.getRequest().getParameter("id");
		
		//O parametro 'op' indica se é para inserir ou remover um item
		if(op != null && op.equals("inserir") && livroId != null) {
			Livro livro = livroService.getLivroById(Integer.parseInt(livroId));
			carrinho.adicionarItem(livro);
		}else if(op != null && op.equals("remover") && livroId !=null) {
			carrinho.removerItem(Integer.parseInt(livroId));
		}
		
		getSession().setAttribute("menuAtivo", "carrinho");

		this.forward("carrinho.jsp");
	}
}
