package com.pharmacie.gestion_pharmacie.web;

import com.pharmacie.gestion_pharmacie.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitWebController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/produits";
    }

    @GetMapping("/produits")
    public String listeProduits(Model model) {
        model.addAttribute("produits", produitRepository.findAll());
        return "produits";
    }
}


