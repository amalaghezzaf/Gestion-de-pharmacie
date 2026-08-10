package com.pharmacie.gestion_pharmacie.repository;

import com.pharmacie.gestion_pharmacie.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
