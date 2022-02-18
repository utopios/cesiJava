package com.example.caisseenregistreusemvc.repository;

import com.example.caisseenregistreusemvc.model.Paiement;
import org.springframework.data.repository.CrudRepository;

public interface PaiementRepository extends CrudRepository<Paiement, Integer> {
}
