package com.example.caisseenregistreusemvc.controller;

import com.example.caisseenregistreusemvc.model.Produit;
import com.example.caisseenregistreusemvc.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    ProduitRepository produitRepository;

    @RequestMapping("/")
    public String getProduits(Model model) {
        List<Produit> produits = (List<Produit>) produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "produits";
    }

    @RequestMapping("/search")
    public  String rechercheProduits(@RequestParam("search") String search, Model model) {
        List<Produit> produits = produitRepository.findByTitre(search);
        model.addAttribute("produits", produits);
        return "produits";
    }

    @GetMapping("/produit/form")
    public String formProduit(Model model) {
        //Préparer le model pour le formulaire d'ajout
        return "form_produit";
    }

    @PostMapping("/produit")
    public RedirectView submitProduit(@ModelAttribute Produit produit, Model model) {
        //Après l'enregistrement du produit
        return new RedirectView("/");
    }


}
