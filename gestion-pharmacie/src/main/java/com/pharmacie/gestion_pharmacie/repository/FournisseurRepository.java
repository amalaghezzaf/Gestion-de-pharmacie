package com.pharmacie.gestion_pharmacie.repository;

import com.pharmacie.gestion_pharmacie.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}