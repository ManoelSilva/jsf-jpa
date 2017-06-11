package br.com.jsfJpa.jpa;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseGen {
	public static void main(String[] args) {
		Properties config = new Properties();
		config.put("hibernate.hbm2ddl.auto", "create");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni7-pu", config);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		// Fabricante fabricante = em.find(Fabricante.class, 1);
		// System.out.println(fabricante.getNome());

		/*
		 * Produto produtoUm = new Produto(null, "notebook", new
		 * BigDecimal(2000.00)); Produto produtoDois = new Produto(null,
		 * "mouse", new BigDecimal(70.00)); Produto produtoTres = new
		 * Produto(null, "teclado", new BigDecimal(100.00)); Produto
		 * produtoQuatro = new Produto(null, "gpu", new BigDecimal(1000.00));
		 * 
		 * em.persist(produtoUm); em.persist(produtoDois);
		 * em.persist(produtoTres); em.persist(produtoQuatro);
		 */

		/*
		 * Produto p = em.find(Produto.class, 2); if (p != null) { em.remove(p);
		 * }
		 * 
		 * Query q = em.createQuery("select p from Produto p"); List<Produto>
		 * produtos = q.getResultList();
		 */

		em.getTransaction().commit();

		/*
		 * for (Produto p1 : produtos) { System.out.println(p1.getId());
		 * System.out.println(p1.getNome()); System.out.println(p1.getPreco());
		 * }
		 */

		em.close();
		factory.close();
	}
}
