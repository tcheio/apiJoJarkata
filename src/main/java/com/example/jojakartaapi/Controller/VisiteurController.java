package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.Services.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("getVisiteur/{id}")
    public ResponseEntity<Visiteur> getVisiteurById(@PathVariable Long id) {
        return visiteurService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Visiteur> createVisiteur(@RequestBody Visiteur visiteur) {
        System.out.println("Received request to create Visiteur: " + visiteur);
        Visiteur createdVisiteur = visiteurService.createVisiteur(visiteur);
        return ResponseEntity.ok(createdVisiteur);
    }

    @PutMapping("UpdateVisiteur/{id}")
    public ResponseEntity<Visiteur> updateVisiteur(@PathVariable Long id, @RequestBody Visiteur visiteurDetails) {
        try {
            Visiteur updatedVisiteur = visiteurService.update(id, visiteurDetails);
            return ResponseEntity.ok(updatedVisiteur);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("DeleteVisiteur/{id}")
    public ResponseEntity<Void> deleteVisiteur(@PathVariable Long id) {
        visiteurService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Visiteur> login(@RequestParam String username, @RequestParam String password) {
        Visiteur visiteur = visiteurService.authenticate(username, password);
        if (visiteur != null) {
            return ResponseEntity.ok(visiteur);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
