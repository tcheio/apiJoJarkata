package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jojakartaapi.Error.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class VisiteurService {

    @Autowired
    private VisiteurRepository visiteurRepository;

    public List<Visiteur> findAll() {
        return visiteurRepository.findAll();
    }

    public Optional<Visiteur> findById(Long id) {
        return visiteurRepository.findById(id);
    }

    public Visiteur save(Visiteur visiteur) {
        return visiteurRepository.save(visiteur);
    }

    public void deleteById(Long id) {
        visiteurRepository.deleteById(id);
    }

    public Visiteur update(Long id, Visiteur visiteurDetails) {
        return visiteurRepository.findById(id)
                .map(visiteur -> {
                    visiteur.setNom(visiteurDetails.getNom());
                    visiteur.setEmail(visiteurDetails.getEmail());
                    visiteur.setTelephone(visiteurDetails.getTelephone());
                    return visiteurRepository.save(visiteur);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Visiteur not found with id " + id));
    }

    public Visiteur getVisiteurById(Long id) {
        return visiteurRepository.findById(id).orElse(null);
    }
}
