package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.Services.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jojakartaapi.Error.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/visiteurs")
public class VisiteurController {

    @Autowired
    private VisiteurService visiteurService;

    @GetMapping
    public List<Visiteur> getAllVisiteurs() {
        return visiteurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visiteur> getVisiteurById(@PathVariable Long id) {
        return visiteurService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Visiteur createVisiteur(@RequestBody Visiteur visiteur) {
        return visiteurService.save(visiteur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visiteur> updateVisiteur(@PathVariable Long id, @RequestBody Visiteur visiteurDetails) {
        try {
            Visiteur updatedVisiteur = visiteurService.update(id, visiteurDetails);
            return ResponseEntity.ok(updatedVisiteur);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisiteur(@PathVariable Long id) {
        visiteurService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
