package com.example.caisseenregistreusemvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public abstract class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int reference;

    protected LocalDateTime dateTime;

    protected Paiement() {
        this.dateTime = LocalDateTime.now();
    }

    public abstract boolean payer(BigDecimal montant);
}
