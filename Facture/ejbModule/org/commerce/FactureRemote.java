package org.commerce;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface FactureRemote {

	public Facture addFacture(Utilisateur user, double total);
	
	public List<Facture> getFactures();

}
