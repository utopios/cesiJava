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
        return new Vente();
    }

    public boolean ajouterProduit(Produit produit){
        return produits.add(produit);
    }

    public boolean ajouterVente(Vente vente){
        return ventes.add(vente);
    }
    public Produit getProduit(int reference) {
        Produit produit = null;
        for(Produit p : produits) {
            if(p.getNumero() == reference) {
                produit = p;
                break;
            }
        }
        return produit;
    }

    public Vente getVente(int reference) {
        Vente vente = null;
        for(Vente v : ventes) {
            if(v.getNumero() == reference) {
                vente = v;
                break;
            }
        }
        return  vente;
    }

}
