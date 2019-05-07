package com.devoir.demo.entities;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partenaire extends Client {

    private int numBanquaire ;

}
