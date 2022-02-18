package com.example.caisseenregistreusemvc.repository;

import com.example.caisseenregistreusemvc.model.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {
    List<Produit> findByTitre(String titre);

    @Query("from Produit p where p.numero =:id")
    List<Produit> veryCustomMethod(int id);
}
