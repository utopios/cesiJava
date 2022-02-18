package com.example.caisseenregistreusemvc.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String etat;

    @ManyToMany
    @JoinTable(name = "vente_produit",
            joinColumns = @JoinColumn(name = "vente_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private ArrayList<Produit> produits;

    @OneToOne
    @JoinColumn(name = "paiement_id")
    private Paiement paiement;


    public  Vente() {
        etat = "En cours";
        produits = new ArrayList<>();
    }
    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public int getNumero() {
        return numero;
    }

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
