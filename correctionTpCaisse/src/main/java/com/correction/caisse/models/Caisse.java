package com.correction.caisse.models;

import java.util.ArrayList;

public class Caisse {
    private ArrayList<Produit> produits;
    private ArrayList<Vente> ventes;

    public  Caisse() {
        produits  = new ArrayList<>();
        ventes = new ArrayList<>();
    }

    public Vente creerVente() {
        return null;
    }

    public boolean ajouterProduit(Produit produit){
        return false;
    }

    public Produit getProduit(int reference) {
        return  null;
    }

    public Vente getVente(int reference) {
        return null;
    }

}
