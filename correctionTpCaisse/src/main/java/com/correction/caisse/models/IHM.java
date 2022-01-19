package com.correction.caisse.models;

import java.util.Scanner;

public class IHM {
    private Caisse caisse;
    private Scanner scanner;
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
            switch (choix) {

            }
        }while (!choix.equals("0"));
    }

    private void menu() {
        System.out.println("1---Ajouter un produit");
        System.out.println("2---Faire une vente");
        System.out.println("0---Quiiter");
    }
}
