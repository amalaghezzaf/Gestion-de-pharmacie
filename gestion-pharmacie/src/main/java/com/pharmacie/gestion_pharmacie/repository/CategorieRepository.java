package com.pharmacie.gestion_pharmacie.repository;

import com.pharmacie.gestion_pharmacie.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}