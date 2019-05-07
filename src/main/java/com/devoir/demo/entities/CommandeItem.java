package com.devoir.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommandeItem implements Serializable {
    @EmbeddedId
    private CommandeItemId id = new CommandeItemId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("commandeId")
    private Commande commande;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("produitId")
    private Produit produit;

    private int quantite;
}
