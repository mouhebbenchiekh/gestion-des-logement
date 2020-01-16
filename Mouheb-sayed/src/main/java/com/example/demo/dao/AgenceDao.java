package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Agence;
import com.example.demo.entites.Clients;

public interface AgenceDao extends JpaRepository<Agence, Long>{
	@Query("select c from Agence c where c.email like :e and c.password like :p ")
	Agence Authentification(@Param("e")String email,@Param("p")String password);

}
