package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Clients;



public interface ClientDao extends JpaRepository<Clients, Long> {
	@Query("select c from Clients c where c.email like :e and c.password like :p ")
	Clients Authentification(@Param("e")String email,@Param("p")String password);
	

}
