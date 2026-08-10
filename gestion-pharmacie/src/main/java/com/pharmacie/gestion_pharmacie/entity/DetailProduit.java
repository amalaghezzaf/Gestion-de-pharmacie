package com.pharmacie.gestion_pharmacie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "detail_produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabricant;

    private String paysOrigine;

    @Column(length = 500)
    private String composition;

    private String dosage;

    @Column(length = 500)
    private String indications;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "detailProduit")
    private Produit Produit;
}