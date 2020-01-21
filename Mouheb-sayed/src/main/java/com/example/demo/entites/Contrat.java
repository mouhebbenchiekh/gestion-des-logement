package com.example.demo.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data

public class Contrat implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="client")
	public Clients client;
	@ManyToOne
	@JoinColumn(name="logement")
	public Logement logement;
	private Date datedebut;
	private Date datefin;
	private String etat;
	
	public Contrat(Long id, Clients client, Logement logement, Date datedebut, Date durée,String etat) {
		super();
		this.id = id;
		this.client = client;
		this.logement = logement;
		this.datedebut = datedebut;
		this.datefin = durée;
		this.etat=etat;
		}
	public Contrat( Clients client, Logement logement, Date datedebut, Date durée,String etat) {
		super();
		
		this.client = client;
		this.logement = logement;
		this.datedebut = datedebut;
		this.datefin = durée;
		this.etat=etat;
	}
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	public Logement getLogement() {
		return logement;
	}
	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date durée) {
		this.datefin = durée;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	

}
