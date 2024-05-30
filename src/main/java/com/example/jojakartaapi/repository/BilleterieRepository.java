package com.example.jojakartaapi.repository;

import com.example.jojakartaapi.model.Billeterie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BilleterieRepository extends JpaRepository<Billeterie, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}

