package livraria.action;

import java.util.ArrayList;
import java.util.List;

import livraria.entity.Usuario;
import livraria.service.UsuarioService;
import webf.action.Action;
import webf.util.StringUtils;

/**
 * 
 * Cadastra um novo usuario no sistema
 * 
 * @author Fernando
 *
 */
public class CadastrarUsuarioAction extends Action {

	@Override
	public void process() throws Exception {

		String email = getRequest().getParameter("email");
		
		if(email== null) {
			// Se o parametro 'email' nao existe é porque o usuário abriu a tela para preencher o formulário
			this.forward("cadastrar_usuario.jsp");
		}
		
		// Extrai os dados digitados no formulário
		email = email.trim();
		String nome = getRequest().getParameter("nome").trim();
		String senha1 = getRequest().getParameter("senha1").trim();
		String senha2 = getRequest().getParameter("senha2").trim();
		
		// Faz a validacao dos dados digitados
		validarEmail(email);
		validarNome(nome);
		validarSenha(senha1,senha2);
		
		// Caso tenha ocorrido algum erro de validacao, coloca as informacoes novamente na request ( para permitir que o
		// formulario exiba os campos preenchidos) e volta para a mesma tela.
		if(existemErros()) {
			this.definirValores(email, nome, senha1, senha2);
			this.forward("cadastrar_usuario.jsp");
		}else {
			// Cria o objeto que representa o usuario
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setSenha(senha1);
			UsuarioService usuarioService = (UsuarioService)this.serviceFactory.getService(UsuarioService.class);
			boolean sucesso = usuarioService.salvar(usuario);
			if(!sucesso) {
				this.adicionarErro("Usupario já existe");
				this.definirValores(email, nome, senha1, senha2);
				this.forward("cadastrar_usuario.jsp");
			}else {
				this.redirect("usuario_cadastrado.jsp");
			}
		}		
	}

	
	/**
	 * Coloca os valores pelo formulario novamente na request, para que possam ser exibidos novamente apos o
	 * carregamento da pagina
	 * @param email
	 * @param nome
	 * @param senha1
	 * @param senha2
	 */
	private void definirValores(String email, String nome, String senha1, String senha2) {
		getRequest().setAttribute("email", email);
		getRequest().setAttribute("nome", nome);
		getRequest().setAttribute("senha1", senha1);
		getRequest().setAttribute("senha2", senha2);
	}
	/**
	 * Valida o e-mail
	 * @param email
	 */
	private void validarEmail(String email) {
		if(StringUtils.isEmpty(email)) {
			adicionarErro("O e-mail é obrigatorio");
		}
		if(email.length() > 50) {
			adicionarErro("O e-mail digitado é muito grande");
		}
		
		//Valida com base em uma expressao regular
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			adicionarErro("O e-mail digitado nao tem formato valido");
		}
	}
	/**
	 * Valida o nome
	 * @param nome
	 */
	private void validarNome(String nome) {
		if(StringUtils.isEmpty(nome)) {
			adicionarErro("O nome é obrigatório");
		}
		if(nome.length()>50) {
			adicionarErro("O nome digitado é muito grande");
		}
	}
	/**
	 * Valida a senha e verifica se ambas as senhas digitadas sao iguais
	 * @param senha1
	 * @param senha2
	 */
	private void validarSenha(String senha1, String senha2) {
		
			if(StringUtils.isEmpty(senha1)) {
				adicionarErro("A senha é obrigatório");
			}
			if(senha1.length()>20) {
				adicionarErro("O senha digitada é muito grande");
			}
			if(StringUtils.isEmpty(senha2)) {
				adicionarErro("A confirmação de senha é obrigatório");
			}
			if(senha2.length()>20) {
				adicionarErro("O senha digitada é muito grande");
			}
			
			if(!senha1.equals(senha2)) {
				adicionarErro("As senhas digitadas são diferentes");
			}
		}
	/**
	 * Adiciona um erro de valicao na request. Isto é feito através da colocação de uma list de erros na request
	 * @param erro
	 */
	@SuppressWarnings("unchecked")
	private void adicionarErro(String erro) {
		List<String> erros = (List) getRequest().getAttribute("erros");
		if(erros == null) {
			erros = new ArrayList<String>();
			this.getRequest().setAttribute("erros", erros);
		}
		((List)erros).add(erro);
	}
	
	/**
	 * Verifica se existem erros de validacao
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean existemErros() {
		List<String> erros = (List<String>)this.getRequest().getAttribute("erros");
		return erros != null && erros.size()!=0;
	}
}
