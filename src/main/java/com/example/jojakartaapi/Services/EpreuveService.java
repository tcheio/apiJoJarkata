package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.Error.ResourceNotFoundException;
import com.example.jojakartaapi.model.Epreuve;
import com.example.jojakartaapi.repository.EpreuveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpreuveService {

    @Autowired
    private EpreuveRepository epreuveRepository;

    public Epreuve createEpreuve(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    public List<Epreuve> getAllEpreuves() {
        return epreuveRepository.findAll();
    }

    public Optional<Epreuve> getEpreuveById(Long id) {
        return epreuveRepository.findById(id);
    }

    public Epreuve updateEpreuve(Long id, Epreuve epreuveDetails) {
        return epreuveRepository.findById(id)
                .map(epreuve -> {
                    epreuve.setLibelle(epreuveDetails.getLibelle());
                    epreuve.setLieu(epreuveDetails.getLieu());
                    epreuve.setDate(epreuveDetails.getDate());
                    epreuve.setNbPlaces(epreuveDetails.getNbPlaces());
                    return epreuveRepository.save(epreuve);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Epreuve not found with id " + id));
    }

    public void deleteEpreuve(Long id) {
        epreuveRepository.deleteById(id);
    }
}
