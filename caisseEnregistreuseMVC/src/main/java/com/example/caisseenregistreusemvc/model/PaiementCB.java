package com.example.caisseenregistreusemvc.model;

import java.math.BigDecimal;

public class PaiementCB extends Paiement {
    private static int compteur = 0;

    public  PaiementCB() {
        super();
        reference = ++compteur;
    }

    @Override
    public boolean payer(BigDecimal montant) {
        return montant.intValue()%2 == 0;
    }
}
