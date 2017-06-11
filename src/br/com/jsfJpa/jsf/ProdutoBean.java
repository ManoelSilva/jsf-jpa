package br.com.jsfJpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.jsfJpa.jpa.Produto;

@ManagedBean
public class ProdutoBean {
	private EntityManagerFactory factory;
	private Produto produto;

	public ProdutoBean() {
		factory = Persistence.createEntityManagerFactory("uni7-pu");
		produto = new Produto();
	}

	public String insert() {
		String next = "produtos";

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(produto);
		produto = new Produto();
		em.getTransaction().commit();
		em.close();

		return next;
	}

	public List<Produto> getProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query query = em.createQuery("select p from Produto p");
		produtos = query.getResultList();
		em.getTransaction().commit();

		em.close();

		return produtos;
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}