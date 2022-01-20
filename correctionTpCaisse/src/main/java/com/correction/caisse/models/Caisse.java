package com.correction.caisse.models;

import com.correction.caisse.dao.ProduitDAO;
import com.correction.caisse.dao.VenteDAO;

import java.sql.SQLException;
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
        //return produits.add(produit);
       try {
           return new ProduitDAO().create(produit);
       }catch(SQLException ex) {
           return  false;
       }
    }

    public boolean ajouterVente(Vente vente){
        //return ventes.add(vente);
        try {
            return new VenteDAO().create(vente);
        }catch(SQLException ex) {
            return  false;
        }
    }
    public Produit getProduit(int reference) {
        Produit produit = null;
       /* for(Produit p : produits) {
            if(p.getNumero() == reference) {
                produit = p;
                break;
            }
        }*/
        try {
            ProduitDAO dao = new ProduitDAO();
            produit = dao.find(reference);
        }catch (Exception ex) {

        }
        return produit;
    }

    public Vente getVente(int reference) {
        Vente vente = null;
        /*for(Vente v : ventes) {
            if(v.getNumero() == reference) {
                vente = v;
                break;
            }
        }*/
        try {
            VenteDAO dao = new VenteDAO();
            vente = dao.find(reference);
        }catch (Exception ex) {

        }
        return  vente;
    }

}
