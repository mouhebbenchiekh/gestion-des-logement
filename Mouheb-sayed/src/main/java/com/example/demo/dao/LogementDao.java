package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Logement;

public interface LogementDao extends JpaRepository<Logement,Long> {
	Optional<Logement> findById(Long i);

}
