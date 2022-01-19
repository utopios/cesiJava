package com.correction.caisse.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Paiement {
    protected LocalDateTime dateTime;
    protected int reference;
    protected Paiement() {
        this.dateTime = LocalDateTime.now();
    }
    public abstract boolean payer(BigDecimal montant);
}
