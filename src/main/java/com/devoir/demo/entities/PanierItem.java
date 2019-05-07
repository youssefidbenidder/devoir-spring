package com.devoir.demo.entities;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)

public class PanierItem implements Serializable  {


    @EmbeddedId
    private PanierItemId id = new PanierItemId();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("panierId")
    private Panier panier;

    @ManyToOne
    @MapsId("produitId")
    private Produit produit;

    private int quantite;

}
