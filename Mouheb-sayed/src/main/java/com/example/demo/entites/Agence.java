package com.example.demo.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data

public class Agence implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String adresse;
	private String email;
	private String password;
	@OneToMany(mappedBy="agence")
	public Collection<Logement> logement;
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agence(Long id, String name, String adresse, String email, String password, Collection<Logement> logement) {
		super();
		this.id = id;
		this.name = name;
		this.adresse = adresse;
		this.email = email;
		this.password = password;
		this.logement = logement;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Logement> getLogement() {
		return logement;
	}
	public void setLogement(Collection<Logement> logement) {
		this.logement = logement;
	}
	
	

}
