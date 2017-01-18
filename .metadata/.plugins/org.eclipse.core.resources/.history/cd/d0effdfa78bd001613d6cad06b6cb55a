package org.commerce;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class Inscription
 */
@Stateless
@LocalBean
public class UtilisateurStateless implements UtilisateurRemote {

	@PersistenceContext(name = "BddService")
	protected EntityManager em;

	// Inscrit un utilisateur dans la bdd
	public Utilisateur CreateInscription(String nom, String prenom, String email, String mdp, String numRue, String rue, String ville, String codePostal, String pays, String tel, String role) {
		Utilisateur i = new Utilisateur();
		i.setNom(nom);
		i.setPrenom(prenom);
		i.setEmail(email);
		i.setMdp(mdp);
		i.setNumRue(numRue);
		i.setRue(rue);
		i.setVille(ville);
		i.setCodePostal(codePostal);
		i.setPays(pays);
		i.setTel(tel);
		i.setRole(role);
		em.persist(i);
		return i;
	}

	public List<Utilisateur> Connexion(String email, String mdp) {
		Query query = em.createQuery("SELECT i FROM Utilisateur i where i.email = :email and i.mdp = :mdp ");
		query.setParameter("email", email);
		query.setParameter("mdp", mdp);
		return query.getResultList();
	}

}
