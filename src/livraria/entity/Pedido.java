package livraria.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pedido {
	
	private String id;
	private Date data;
	private Integer status;
	private Usuario usuario;
	private Double valor;
	private Set<Livro> livros = new LinkedHashSet<Livro>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Set<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	
}
