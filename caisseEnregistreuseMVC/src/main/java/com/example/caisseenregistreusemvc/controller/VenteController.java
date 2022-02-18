package com.example.caisseenregistreusemvc.controller;

import com.example.caisseenregistreusemvc.model.Produit;
import com.example.caisseenregistreusemvc.model.Vente;
import com.example.caisseenregistreusemvc.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

public class VenteController {

    @Autowired
    ProduitRepository _produitRepository;
    @RequestMapping("/vente")
    public String currentVente(Model model, HttpServletRequest request) {
        Vente vente  = (Vente)request.getSession().getAttribute("VENTE");
        if(vente == null) {
            vente = new Vente();
        }
        model.addAttribute("vente", vente);
        return "vente";
    }

    @GetMapping("/vente/ajouter/produit")
    public RedirectView post(@RequestParam("id") int id, HttpServletRequest request) {
        //Récupérer le produit et de l'ajouter dans la vente
        Produit produit = _produitRepository.findById(id).get();
        //On accède à la session à partir de servlet Request.
        Vente vente  = (Vente)request.getSession().getAttribute("VENTE");
        if(vente == null) {
            vente = new Vente();
        }
        vente.ajouterProduit(produit);
        return new RedirectView("/vente");
    }

    @PostMapping("/vente/validation")
    public RedirectView post(@RequestParam("type_paiement") String typePaiement, Model model, HttpServletRequest request) {
        //Enregistrer la vente
        //il faut chercher la vente dans la session

        return new RedirectView("/");
    }
}
