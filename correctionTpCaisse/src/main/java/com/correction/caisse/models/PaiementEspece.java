package com.correction.caisse.models;

import java.math.BigDecimal;

public class PaiementEspece extends Paiement {
    private static int compteur = 0;

    public BigDecimal getMonnaie() {
        return monnaie;
    }

    private BigDecimal monnaie;

    public  PaiementEspece() {
        reference = ++compteur;
    }

    @Override
    public boolean payer(BigDecimal montant) {
        return false;
    }
}
