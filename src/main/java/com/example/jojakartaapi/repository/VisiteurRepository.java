package com.example.jojakartaapi.repository;

import com.example.jojakartaapi.model.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
}
