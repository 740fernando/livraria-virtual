package livraria.helper;

import java.util.LinkedHashSet;
import java.util.Set;

import livraria.entity.Livro;

public class Carrinho {
	
	// As duas colecoes sao gerenciadas simultaneamente, Uma tem objetos view, e a outra objetos entity.
	// Ambas sao Set, para evitar que livros iguais possam ser adicionados mais de uma vez no carrinho.
	private Set<Livro> livros = new LinkedHashSet<Livro>();
	
	/**
	 * Adiciona um livro ao carrinho
	 * @param livro
	 */
	public void adicionarItem(Livro livro) {
		livros.add(livro);
	}
	/**
	 * Remove um livro do carrinho
	 * @param livroId
	 */
	public void removerItem(Integer livroId) {
		Livro livro = new Livro();
		livro.setId(livroId);
		livros.remove(livro);
	}
	
	/**
	 * Obtem o valor total do carrinho, somando os valores dos itens
	 * @return
	 */
	public Double getValorTotal() {
		double total = 0.0;
		for(Livro livro : livros) {
			total += livro.getPreco();
		}
		return total;
	}
	
	public Set<Livro> getItens(){return livros;}
	
	public Set<Livro> getLivros(){return livros;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livros == null) ? 0 : livros.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrinho other = (Carrinho) obj;
		if (livros == null) {
			if (other.livros != null)
				return false;
		} else if (!livros.equals(other.livros))
			return false;
		return true;
	}
}
