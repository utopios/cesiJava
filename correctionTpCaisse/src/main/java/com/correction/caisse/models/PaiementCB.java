package com.correction.caisse.models;

import java.math.BigDecimal;

public class PaiementCB extends Paiement {
    private static int compteur = 0;

    public  PaiementCB() {
        reference = ++compteur;
    }

    @Override
    public boolean payer(BigDecimal montant) {
        return false;
    }
}
