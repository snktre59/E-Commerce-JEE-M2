package org.commerce;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class Commande
 */
@Stateless
@LocalBean
public class CommandeStateless implements CommandeRemote {


	@PersistenceContext(name = "BddService")
	protected EntityManager em;

	
	public Commande addCommande(Article article, int idClient, double prix, int quantite, Facture facture) {
		Commande i = new Commande();
		i.setArticles(article);
		i.setIdClient(idClient);
		i.setPrix(prix);
		i.setQuantite(quantite);
		i.setFactures(facture);
		em.persist(i);
		return i;
	}

	@Override
	public List<Commande> getCommande()	 {
		Query query = em.createQuery("SELECT c FROM Commande c");
		return (List<Commande>) query.getResultList();
	}
}
