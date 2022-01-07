package livraria.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import livraria.service.PedidoService;
import webf.action.Action;
import webf.util.StringUtils;

public class ProcessarPedidosAction extends Action{

	@Override
	public void process() throws Exception {
		
		//Obtem os pedidos status selcionados na etla
		Map<String, Integer> statusMap = getStatusPedidos();
		
		//Atualiza os dados
		PedidoService pedidoService = (PedidoService) serviceFactory.getService(PedidoService.class);
		pedidoService.atualizarStatus(statusMap);
		
		redirect("admin/GerenciarPedidos.action");
	}
	/**
	 * Obtem os status dos pedidos.
	 * @return Um map mapeando um numero de pedido a um status
	 */
	private Map<String, Integer> getStatusPedidos(){
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		//Itera sobre todos os parametros vindos na request
		Enumeration<String> params = getRequest().getParameterNames();
		
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			if(param.startsWith("status_")) {
				// Se o parametro comeca com 'status_', eh um combo box de status
				
				//Extrai o ID do pedido
				String id = param.substring(7);
				
				//Obtem o status
				String statusStr= getRequest().getParameter(param);
				
				//Se o valor do parametro esta vazio, significa que o pedido nao deve ser processado
				if(!StringUtils.isEmpty(statusStr)) {
					int status = Integer.parseInt(statusStr);
					map.put(id, status);
				}
			}
		}
		return map;
	}

}
