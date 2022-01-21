package com.correction.caisse.models;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Vente {
    private static int compteur = 0;
    private Paiement paiement;


    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public int getNumero() {
        return numero;
    }

    private int numero;
    private String etat;
    private ArrayList<Produit> produits;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEtat() {
        return etat;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public  Vente() {
//        numero = ++compteur;
        etat = "En cours";
        produits = new ArrayList<>();
    }

    public boolean ajouterProduit(Produit produit) {
        return produits.add(produit);
    }

    public boolean valider(Paiement paiement) {
        this.paiement = paiement;
        if(paiement.payer(getTotal())) {
            etat = "validée";
            updateStock();
            return true;
        }else {
            etat = "erreur paiement";
            return false;
        }
    }

    private void updateStock() {
        for (Produit produit: produits) {
           produit.setStock(produit.getStock() - 1);
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
