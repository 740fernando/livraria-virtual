package livraria.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import livraria.dao.LivroDAO;
import livraria.dao.UsuarioDAO;
import livraria.entity.Livro;
import livraria.entity.Usuario;
import webf.dao.DAOFactory;
import webf.util.HibernateUtil;


public class DBCreator {

	public static void main(String[] args) throws Exception {
		
		// Insere os dados
		insertData();
	}
	private static void insertData() throws Exception{
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			HibernateUtil.beginTransaction();
			
			LivroDAO livroDAO = daoFactory.getDAO(LivroDAO.class);
			UsuarioDAO usuarioDAO = daoFactory.getDAO(UsuarioDAO.class);
			
			Livro l = new Livro();
			l.setTitulo("Use a Cabeça! - JAVA ");
			l.setAutor("Kathy Sierra");
			l.setAno(2007);
			l.setPreco(129.9);
			l.setEditora("Starlin Alta Consult");
			livroDAO.save(l);
			
			l= new Livro();
			l.setTitulo("JAVA - Como Programar");
			l.setAutor("Harvey Deitel");
			l.setAno(2010);
			l.setPreco(249.0);
			l.setEditora("Prentice Hall Brasil");
			livroDAO.save(l);
			
			l= new Livro();
			l.setTitulo("JAVA 7");
			l.setAutor("Herbert Schildt");
			l.setAno(2011);
			l.setPreco(159.1);
			l.setEditora("Osborne - McGraw-Hill");
			livroDAO.save(l);
			
			l= new Livro();
			l.setTitulo("JAVA Persistence com Hibernate");
			l.setAutor("Cristian Bauer");
			l.setAno(2007);
			l.setPreco(135.0);
			l.setEditora("Ciencia Moderna");
			livroDAO.save(l);
			
			Usuario u = new Usuario();
			u.setNome("Fernando Luiz");
			u.setEmail("fernando.luiz92@hotmail.com");
			u.setSenha("123");
			usuarioDAO.save(u);
			
			HibernateUtil.commitTransaction();
		}catch(Exception e) {
			HibernateUtil.rollbackTransaction();
			throw e;
		}
	}
}
