package com.devoir.demo.dao;

import com.devoir.demo.entities.Panier;
import com.devoir.demo.entities.PanierItem;
import com.devoir.demo.entities.PanierItemId;
import com.devoir.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierItemRepository extends JpaRepository<PanierItem, PanierItemId> {
    public PanierItem findByPanierAndProduit(Panier panier , Produit produit);
}
