package livraria.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import livraria.entity.Livro;
import livraria.service.LivroService;
import webf.action.Action;
import webf.util.StringUtils;

public class SalvarLivroAction extends Action{

	@Override
	public void process() throws Exception {
		// Lê os dados preenchidos
		String id = getRequest().getParameter("id").trim();
		String titulo = getRequest().getParameter("titulo").trim();
		String autor = getRequest().getParameter("autor").trim();
		String editora = getRequest().getParameter("editora").trim();
		String ano = getRequest().getParameter("ano").trim();
		String preco = getRequest().getParameter("preco").trim();
		
		//Valida os dados
		validarTitulo(titulo);
		validarAutor(autor);
		validarEditora(editora);
		validarAno(ano);
		validarPreco(preco);
		
		// Se existem erros , recoloca os dados na request e retorna para a propia pagina
		if(existemErros()) {
			definirValores(id,titulo,autor,editora,ano,preco);
			forward("livros.jsp");
			return;
		}
		
		// Cria e popula os dados no livro
		Livro livro = new Livro();
		
		if(!StringUtils.isEmpty(id)) {
			// O ID virá preenchido se for uma alteracao de dados
			livro.setId(Integer.parseInt(id));
		}
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setAno(Integer.parseInt(ano));
		livro.setPreco(Double.parseDouble(preco));
		
		// Grava os dados
		LivroService livroService = serviceFactory.getService(LivroService.class);
		livroService.salvar(livro);
		
		redirect("admin/ListarLivros.action");
	}
	
	/**
	 * Recoloca os dados preenchidos na request, para permitir que o formulario já fique preenchido quando
	 * a tela for recarregada
	 * @param id
	 * @param titulo
	 * @param autor
	 * @param editora
	 * @param ano
	 * @param preco
	 */
	private void definirValores(String id,String titulo,String autor,String editora,String ano, String preco) {
		
		getRequest().setAttribute("id", id);
		getRequest().setAttribute("titulo", titulo);
		getRequest().setAttribute("autor", autor);
		getRequest().setAttribute("editora", editora);
		getRequest().setAttribute("ano", ano);
		getRequest().setAttribute("preco", preco);
	}
	
	/**
	 * Adiciona um erro de validacao. Os erros sao armazenados em uma lista, inserida na request
	 * @param erro
	 */
	@SuppressWarnings("unchecked")
	private void adicionarErro(String erro) {
		List<String> erros =(List<String>) getRequest().getAttribute("erros");
		if(erros == null) {
			erros = new ArrayList<String>();
			getRequest().setAttribute("erros", erros);
		}
		erros.add(erro);
	}
	/**
	 * Verifica se existem erros de valicadao
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean existemErros() {
		List<String> erros = (List<String>) getRequest().getAttribute("erros");
		if(erros == null || erros.size() == 0) {
			return false;
		}
		return true;
	} 
	private void validarTitulo(String titulo) {
		if(StringUtils.isEmpty(titulo)) {
			adicionarErro("O título é obrigatório");
		}
		if(titulo.length() > 50) {
			adicionarErro("O título digitado é muito grande");
		}
	}
	/**
	 * Valida o autor
	 * @param autor
	 */
	private void validarAutor(String autor) {
		if(StringUtils.isEmpty(autor)) {
			adicionarErro("O autor é obrigatório");
		}
		if(autor.length()>50) {
			adicionarErro("O autor digitado é muito grande");
		}
	}
	
	/**
	 * Valida a editora
	 * @param editora
	 */
	private void validarEditora(String editora) {
		if(StringUtils.isEmpty(editora)) {
			adicionarErro("O editora é obrigatório");
		}
		if(editora.length()>25) {
			adicionarErro("O editora digitado é muito grande");
		}
	}
	/**Valida o ano
	 * @param ano
	 */
	private void validarAno(String ano) {
		if(StringUtils.isEmpty(ano)) {
			adicionarErro("O Ano é obrigatório");
		}else if(!StringUtils.isInteger(ano)) {
			adicionarErro("O ano deve ser um numero inteiro válido");
		}else {
			//Obtem o ano atual do sistema
			Calendar c = Calendar.getInstance();
			int anoAtual = c.get(Calendar.YEAR);
			
			int anoInt = Integer.parseInt(ano);
			
			//O ano deve ser maior ou igual a 1900 e menor ou igual ao ano atual
			if(anoInt < 1900 || anoInt > anoAtual) {
				adicionarErro("O ano está fora do intervalo válido");
			}
		}
	}
	private void validarPreco(String preco) {
		if(StringUtils.isEmpty(preco)) {
			adicionarErro("O preco é obrigatório");
		}else if(!StringUtils.isDouble(preco)) {
			adicionarErro("O preco deve ser um valor válido");
		}else {
			double precoDouble = Double.parseDouble(preco);	
			if(precoDouble < 0) {
				adicionarErro("O preco não pode ser negativo");
			}
		}
	}
}
