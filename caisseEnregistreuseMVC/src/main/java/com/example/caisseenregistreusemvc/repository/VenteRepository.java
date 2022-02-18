package com.example.caisseenregistreusemvc.repository;

import com.example.caisseenregistreusemvc.model.Vente;
import org.springframework.data.repository.CrudRepository;

public interface VenteRepository extends CrudRepository<Vente, Integer> {
}
