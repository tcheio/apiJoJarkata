package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.Error.ResourceNotFoundException;
import com.example.jojakartaapi.model.Epreuve;
import com.example.jojakartaapi.Services.EpreuveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Epreuve>> getAllEpreuves() {
        List<Epreuve> epreuves = epreuveService.getAllEpreuves();
        return new ResponseEntity<>(epreuves, HttpStatus.OK);
    }

    @GetMapping("getEpreuve/{id}")
    public ResponseEntity<Epreuve> getEpreuveById(@PathVariable Long id) {
        return epreuveService.getEpreuveById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("updateEpreuve/{id}")
    public ResponseEntity<Epreuve> updateEpreuve(@PathVariable Long id, @RequestBody Epreuve epreuveDetails) {
        try {
            Epreuve updatedEpreuve = epreuveService.updateEpreuve(id, epreuveDetails);
            return ResponseEntity.ok(updatedEpreuve);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteEpreuve/{id}")
    public ResponseEntity<Void> deleteEpreuve(@PathVariable Long id) {
        epreuveService.deleteEpreuve(id);
        return ResponseEntity.noContent().build();
    }
}
