package com.pharmacie.gestion_pharmacie.repository;

import com.pharmacie.gestion_pharmacie.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
