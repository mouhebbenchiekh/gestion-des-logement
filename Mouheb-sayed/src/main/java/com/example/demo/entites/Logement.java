package com.example.demo.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "logement" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Logement implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="libelle")
	private String libelle;
	@Column(name="description")
	private String description;
	private double surface;
	private double prix;
	private String image;
	@ManyToOne
	@JoinColumn(name="agence")
	public Agence agence;
	@OneToMany(mappedBy="logement")
	public Collection<Contrat> contrat;
	
	public Logement(Long id, String libelle, String description, double surface, double prix, String image) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.surface = surface;
		this.prix = prix;
		this.image = image;
	}
	
	public Logement(Long id, String libelle, String description, double surface, double prix, String image,
			Agence agence, Collection<Contrat> contrat) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.surface = surface;
		this.prix = prix;
		this.image = image;
		this.agence = agence;
		this.contrat = contrat;
	}

	public Logement(Long id, String libelle, String description, double surface, double prix, String image,
			Agence agence) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.surface = surface;
		this.prix = prix;
		this.image = image;
		this.agence = agence;
	}

	public Logement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Contrat> getContrat() {
		return contrat;
	}

	public void setContrat(Collection<Contrat> contrat) {
		this.contrat = contrat;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSurface() {
		return surface;
	}
	public void setSurface(double surface) {
		this.surface = surface;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence=agence;
	}

}
