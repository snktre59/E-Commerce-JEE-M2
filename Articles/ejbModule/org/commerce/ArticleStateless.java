package org.commerce;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class Article
 */
@Stateless
@LocalBean
public class ArticleStateless implements ArticleRemote {

	@PersistenceContext(name = "BddService")
	protected EntityManager em;

	public Article createArticle(String designation, String categorie, String description, double prix, int stock) {
		Article a = new Article();
		a.setDescription(description);
		a.setDesignation(designation);
		a.setCategorie(categorie);
		a.setPrix(prix);
		a.setStock(stock);
		em.persist(a);
		return a;
	}

	public List<Article> getAllArticle() {
		Query query = em.createQuery("SELECT a FROM Article a");
		return (List<Article>) query.getResultList();
	}

	public List<Article> getArticle(String type) {
		Query query = em.createQuery("SELECT a FROM Article a where categorie=:categorie");
		return (List<Article>) query.setParameter("categorie", type).getResultList();
	}

	@Override
	public List<Article> getArticlePanier(List<Integer> id) {

		Query query = em.createQuery("SELECT a FROM Article a where id IN(:id)");

		// System.out.println(query);
		return (List<Article>) query.setParameter("id", id).getResultList();
	}

	public void MaJStockArticle(int id, int stock) {
		Query query = em.createQuery("UPDATE Article set stock = :stock where id=:id");
		query.setParameter("id", id).setParameter("stock", stock).executeUpdate();
	}
	
	public Article getSingleArticle(int id) {
		Query query = em.createQuery("SELECT a FROM Article a where id =:id");
		Article a = (Article) query.setParameter("id", id).getSingleResult();
		if(a != null) {
			return a;
		}
		else return null;
		
	}

}
