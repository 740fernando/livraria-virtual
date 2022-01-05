package livraria.action;

import java.util.ArrayList;
import java.util.List;

import livraria.entity.Pedido;
import livraria.entity.Usuario;
import livraria.service.PedidoService;
import webf.action.Action;

public class ListarPedidosAction extends Action {
	
	public ListarPedidosAction() {
	
	}

	@Override
	public void process() throws Exception {
		
		getSession().setAttribute("menuAtivo", "pedidos");
		Usuario usuario = (Usuario) getSession().getAttribute("usuario");
		
		//Só obtém os pedidos se existir um usuário logado
		if(usuario != null) {
			PedidoService pedidoService = (PedidoService) serviceFactory.getService(PedidoService.class);
			List<Pedido> pedidos = pedidoService.getPedidosByUsuario(usuario);
			
			List<PedidoView> pedidosView = new ArrayList();
			for(Pedido pedido : pedidos) {
				PedidoView pedidoView = new PedidoView(pedido);
				pedidoView.add(pedidoView);
			}
			
			getRequest().setAttribute("pedidos", pedidosView);
		}
		forward("lista_pedidos.jsp");
	}
}
