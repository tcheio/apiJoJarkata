package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.model.Epreuve;
import com.example.jojakartaapi.repository.EpreuveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpreuveService {

    @Autowired
    private EpreuveRepository epreuveRepository;

    public Epreuve createEpreuve(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    public Epreuve getEpreuveById(Long id) {
        return epreuveRepository.findById(id).orElse(null);
    }
}
