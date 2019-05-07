package com.devoir.demo.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PanierItemId  implements Serializable {

    @Column(name = "panier_id")
    private long panierId;

    @Column(name = "produit_id")
    private long produitId;

}
