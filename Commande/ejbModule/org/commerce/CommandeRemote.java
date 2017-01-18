package org.commerce;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CommandeRemote {

	public Commande addCommande(Article article, int idClient, double prix, int quantite, Facture facture);
	
	public List<Commande> getCommande();
}
