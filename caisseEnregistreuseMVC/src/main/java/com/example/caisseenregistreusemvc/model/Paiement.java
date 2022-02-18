package com.example.caisseenregistreusemvc.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public abstract class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int reference;

    @Column(name = "date_paiement")
    protected LocalDateTime dateTime;

    protected Paiement() {
        this.dateTime = LocalDateTime.now();
    }

    public abstract boolean payer(BigDecimal montant);
}
