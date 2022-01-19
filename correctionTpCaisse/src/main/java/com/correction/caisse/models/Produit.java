package com.correction.caisse.models;

import java.math.BigDecimal;

public class Produit {
    private static int compteur = 0;
    private int numero;
    private BigDecimal prix;
    private int stock;
    private String titre;


    public Produit(BigDecimal prix, int stock, String titre) {
        this.prix = prix;
        this.stock = stock;
        this.titre = titre;
        this.numero = ++compteur;
    }

    public int getNumero() {
        return numero;
    }


    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
