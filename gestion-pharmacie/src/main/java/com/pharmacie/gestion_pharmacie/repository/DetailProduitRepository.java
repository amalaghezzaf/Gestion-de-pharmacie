package com.pharmacie.gestion_pharmacie.repository;

import com.pharmacie.gestion_pharmacie.entity.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProduitRepository extends JpaRepository<DetailProduit, Long> {
}
