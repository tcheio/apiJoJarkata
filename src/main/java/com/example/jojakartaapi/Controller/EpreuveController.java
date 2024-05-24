package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.model.Epreuve;
import com.example.jojakartaapi.Services.EpreuveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/epreuves")
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

    @PostMapping
    public ResponseEntity<Epreuve> createEpreuve(@RequestBody Epreuve epreuve) {
        Epreuve newEpreuve = epreuveService.createEpreuve(epreuve);
        return new ResponseEntity<>(newEpreuve, HttpStatus.CREATED);
    }
}
