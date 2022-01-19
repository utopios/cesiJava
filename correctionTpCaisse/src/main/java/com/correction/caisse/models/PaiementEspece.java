package com.correction.caisse.models;

import java.math.BigDecimal;

public class PaiementEspece extends Paiement {
    private static int compteur = 0;

    public BigDecimal getMonnaie() {
        return monnaie;
    }

    private BigDecimal monnaie;
    private  BigDecimal montantClient;
    public  PaiementEspece() {
        super();
        reference = ++compteur;
    }


    public  PaiementEspece(BigDecimal montantClient) {
        this();
        this.montantClient = montantClient;
    }
    @Override
    public boolean payer(BigDecimal montant) {
        if(montantClient.compareTo(montant) >= 0) {
            this.monnaie = this.montantClient.subtract(montant);
            return true;
        }
        return false;
    }
}
