package com.devoir.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    @OneToOne
    private User user;

    @Embedded
    private Adresse adresse;

    @OneToOne
    Panier panier;

}
