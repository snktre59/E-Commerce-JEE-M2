package org.commerce;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Facture implements Serializable{

	private static final long serialVersionUID = -3529102498496535989L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double total;
	@ManyToOne
	private Utilisateur user;


	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
