package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.Error.ResourceNotFoundException;
import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisiteurService {

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Visiteur> findAll() {
        return visiteurRepository.findAll();
    }

    public Optional<Visiteur> findById(Long id) {
        return visiteurRepository.findById(id);
    }

    public Visiteur createVisiteur(Visiteur visiteur) {
        System.out.println("Creating Visiteur: " + visiteur);
        visiteur.setPassword(passwordEncoder.encode(visiteur.getPassword()));
        Visiteur savedVisiteur = visiteurRepository.save(visiteur);
        System.out.println("Visiteur created with ID: " + savedVisiteur.getId());
        return savedVisiteur;
    }
    public Visiteur save(Visiteur visiteur) {
        visiteur.setPassword(passwordEncoder.encode(visiteur.getPassword()));
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
                    if (!visiteurDetails.getPassword().isEmpty()) {
                        visiteur.setPassword(passwordEncoder.encode(visiteurDetails.getPassword()));
                    }
                    return visiteurRepository.save(visiteur);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Visiteur not found with id " + id));
    }

    public Visiteur getVisiteurById(Long id) {
        return visiteurRepository.findById(id).orElse(null);
    }

    public Visiteur authenticate(String username, String password) {
        Visiteur visiteur = visiteurRepository.findByUsername(username).orElse(null);
        if (visiteur != null && passwordEncoder.matches(password, visiteur.getPassword())) {
            return visiteur;
        }
        return null;
    }
}
