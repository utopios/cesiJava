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
        return  false;
    }

    public boolean valider(Paiement paiement) {
        return false;
    }

    public BigDecimal getTotal() {
        return BigDecimal.valueOf(0);
    }

}
