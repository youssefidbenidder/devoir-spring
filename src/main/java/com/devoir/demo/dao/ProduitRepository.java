package com.devoir.demo.dao;

import com.devoir.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    public List<Produit> findByNom(String productName);
    public void deleteById(Long id);
}
