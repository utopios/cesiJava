package com.example.caisseenregistreusemvc.controller;

import com.example.caisseenregistreusemvc.model.Produit;
import com.example.caisseenregistreusemvc.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    ProduitRepository produitRepository;

    public String getProduits(Model model) {
        List<Produit> produits = (List<Produit>) produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "produits";
    }

    public  String rechercheProduits(@RequestParam("search") String search, Model model) {
        List<Produit> produits = produitRepository.findByTitre(search);
        model.addAttribute("produits", produits);
        return "produits";
    }
}
