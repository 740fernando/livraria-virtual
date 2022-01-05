package livraria.action;

import java.util.Set;

import livraria.entity.Livro;
import livraria.entity.Usuario;
import livraria.service.PedidoService;
import webf.action.Action;

public class FecharPedidoAction extends Action{

	public FecharPedidoAction() {
	}
	
	@Override
	public void process() throws Exception {
		Carrinho carrinho = getSession().getAttribute("carrinho");
		Usuario usuario =(Usuario) getSession().getAttribute("usuario");
		PedidoService pedidoService = serviceFactory.getService(PedidoService.class);
		Set<Livro> livros = carrinho.getLivros();
		pedidoService.fecharPedido(usuario, livros);
		getSession().setAttribute("carrinho", (Object)null);
		redirect("pedido_efetuado.jsp");
	}
}
