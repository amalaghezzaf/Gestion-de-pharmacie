package com.pharmacie.gestion_pharmacie.controller;

import com.pharmacie.gestion_pharmacie.entity.Produit;
import com.pharmacie.gestion_pharmacie.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        Produit saved = produitRepository.save(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        return produitRepository.findById(id)
                .map(produit -> {
                    produit.setNom(produitDetails.getNom());
                    produit.setDescription(produitDetails.getDescription());
                    produit.setPrix(produitDetails.getPrix());
                    produit.setCodeBarre(produitDetails.getCodeBarre());
                    produit.setDateExpiration(produitDetails.getDateExpiration());
                    produit.setCategorie(produitDetails.getCategorie());
                    produit.setFournisseur(produitDetails.getFournisseur());
                    produit.setDetailProduit(produitDetails.getDetailProduit());
                    produit.setTags(produitDetails.getTags());
                    Produit updated = produitRepository.save(produit);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        return produitRepository.findById(id)
                .map(produit -> {
                    produitRepository.delete(produit);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
