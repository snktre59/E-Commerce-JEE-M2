package org.commerce;

import java.util.Date;
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
public class FactureStateless implements FactureRemote {

	Date date = new Date();
	@PersistenceContext(name = "BddService")
	protected EntityManager em;
	
	
	public Facture addFacture(Utilisateur user, double total) {
		Facture i = new Facture();
		i.setUser(user);
		i.setTotal(total);
		em.persist(i);
		return i;
	}


	@Override
	public List<Facture> getFactures() {
		Query query = em.createQuery("SELECT f from Facture f");
		return (List<Facture>) query.getResultList();
	}

}
