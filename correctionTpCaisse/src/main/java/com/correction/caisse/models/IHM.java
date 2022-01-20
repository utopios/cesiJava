package com.correction.caisse.models;

import java.math.BigDecimal;
import java.util.Scanner;

public class IHM {
    private Caisse caisse;
    private Scanner scanner;
    private Vente vente;
    private String choixMenuVente;
    public  IHM() {
        caisse = new Caisse();
        scanner = new Scanner(System.in);
    }
    public  void start() {
        String choix;
        do {
            menu();
            System.out.print("Votre choix : ");
            choix = scanner.next();
            System.out.flush();
            switch (choix) {
                case "1":
                    actionAjoutProduitCaisse();
                    break;
                case "2":
                   actionVente();
                    break;
            }
        }while (!choix.equals("0"));
    }

    private void actionAjoutProduitCaisse() {
        System.out.print("Merci de saisir le titre du produit : ");
        String titre = scanner.next();
        System.out.print("Merci de saisir le stock du produit : ");
        int stock = scanner.nextInt();
        System.out.print("Merci de saisir le prix du produit : ");
        BigDecimal prix = scanner.nextBigDecimal();
        if(caisse.ajouterProduit(new Produit(prix, stock, titre))) {
            System.out.println("Produit ajouté");
        }
        else {
            System.out.println("Erreur ajout produit");
        }
    }

    private void actionVente() {
        vente = caisse.creerVente();
        do {
            menuVente();
            System.out.print("Votre choix : ");
            choixMenuVente = scanner.next();
            System.out.flush();
            switch (choixMenuVente) {
                case "1":
                    actionAjoutProduitVente();
                    break;
                case "2":
                    actionPaiementCarte();
                    break;
                case "3":
                    actionPaiementEspece();
                    break;
            }
        }while (!choixMenuVente.equals("0"));

    }


    private void actionAjoutProduitVente() {
        System.out.print("Merci de saisir la référence du produit à ajouter : ");
        int reference = scanner.nextInt();
        Produit produit = caisse.getProduit(reference);
        if(produit == null) {
            System.out.println("***** Aucun produit avec cette référence *****");
        }
        else {
            if(vente.ajouterProduit(produit)) {
                System.out.println("---- Produit ajouté ----");
                System.out.format("**** Panier a : %s euros *****\n", vente.getTotal().toString());
            }
            else {
                System.out.println("***** Erreur d'ajout produit *****");
            }
        }
    }
    private void actionPaiementEspece() {
        System.out.print("Merci de saisir la montant client : ");
        BigDecimal montantClient = scanner.nextBigDecimal();
        PaiementEspece paiement = new PaiementEspece(montantClient);
        if(vente.valider(paiement) && caisse.ajouterVente(vente)) {
            System.out.println("***** Vente validée *****");
            System.out.format("**** valeur monnaie  : %s euros *****\n", paiement.getMonnaie().toString());
            choixMenuVente = "0";
        }
        else {
            System.out.println("***** Erreur paiement *****");
        }
    }
    private void actionPaiementCarte() {
        PaiementCB paiement = new PaiementCB();
        if(vente.valider(paiement) && caisse.ajouterVente(vente)) {
            System.out.println("***** Vente validée *****");
            choixMenuVente = "0";
        }
        else {
            System.out.println("***** Erreur paiement *****");
        }
    }
    private void menu() {
        System.out.println("1---Ajouter un produit");
        System.out.println("2---Faire une vente");
        System.out.println("0---Quitter");
    }
    private void menuVente() {
        System.out.println("1---Ajouter produit");
        System.out.println("2---Paiement carte");
        System.out.println("3---Paiement Espece");
    }
}
