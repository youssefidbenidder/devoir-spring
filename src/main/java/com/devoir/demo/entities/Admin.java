package com.devoir.demo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Admin implements Serializable {


    @Id
    @GeneratedValue
    private long id;

    private String email;

    @OneToOne
    private User user;

}
