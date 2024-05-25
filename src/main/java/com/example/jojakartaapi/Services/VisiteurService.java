package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisiteurService {

    @Autowired
    private VisiteurRepository visiteurRepository;

    public Visiteur getVisiteurById(Long id) {
        return visiteurRepository.findById(id).orElse(null);
    }
}
