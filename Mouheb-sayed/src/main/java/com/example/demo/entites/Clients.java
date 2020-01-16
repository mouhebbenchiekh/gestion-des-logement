package com.example.demo.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "clients" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Clients implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column( name = "first_name" )
	private String fname;
	
	@Column( name = "last_name" )
	private String lname;
	
	@Column( name = "adress" )
	private String adress;
	
	@Email
	private String email;
	
	@Column( name = "password" )
	private String password;
	
	@OneToMany(mappedBy="client")
	public Collection<Contrat> contrat;
	

	public Clients(Long id, String fname, String lname, String adress, @Email String email, String password) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.adress = adress;
		this.email = email;
		this.password = password;
	}
	

	public Clients(Long id, String fname, String lname, String adress, @Email String email, String password,
			Collection<Contrat> contrat) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.adress = adress;
		this.email = email;
		this.password = password;
		this.contrat = contrat;
	}


	public Collection<Contrat> getContrat() {
		return contrat;
	}


	public void setContrat(Collection<Contrat> contrat) {
		this.contrat = contrat;
	}


	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
	
	
	
}