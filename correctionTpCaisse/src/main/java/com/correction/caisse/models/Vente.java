package com.correction.caisse.models;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Vente {
    private static int compteur = 0;
    private int numero;
    private String etat;
    private ArrayList<Produit> produits;

    public  Vente() {
        numero = ++compteur;
        etat = "En cours";
        produits = new ArrayList<>();
    }

    public boolean ajouterProduit(Produit produit) {
        return produits.add(produit);
    }

    public boolean valider(Paiement paiement) {
        if(paiement.payer(getTotal())) {
            etat = "validée";
            return true;
        }else {
            etat = "erreur paiement";
            return false;
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (Produit produit: produits) {
            total = total.add(produit.getPrix());
        }
        return total;
    }

}
