package com.pharmacie.gestion_pharmacie.controller;

import com.pharmacie.gestion_pharmacie.entity.Fournisseur;
import com.pharmacie.gestion_pharmacie.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurRestController {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping
    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        return fournisseurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fournisseur> create(@RequestBody Fournisseur fournisseur) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fournisseurRepository.save(fournisseur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable Long id, @RequestBody Fournisseur details) {
        return fournisseurRepository.findById(id)
                .map(f -> {
                    f.setNom(details.getNom());
                    f.setContact(details.getContact());
                    f.setAdresse(details.getAdresse());
                    return ResponseEntity.ok(fournisseurRepository.save(f));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return fournisseurRepository.findById(id)
                .map(f -> {
                    fournisseurRepository.delete(f);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
