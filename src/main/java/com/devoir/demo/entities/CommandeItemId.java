package com.devoir.demo.entities;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder

public class CommandeItemId implements Serializable {
    private long commandeId;
    private long produitId;
}
