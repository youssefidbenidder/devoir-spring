package com.devoir.demo.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@EntityListeners(AuditingEntityListener.class)

public class Produit implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate lastModifiedDate;



    private String nom;

    private String description;

    private Double prix;

    @OneToMany(mappedBy = "produit")
    private List<PanierItem> items;

    @OneToMany(mappedBy = "produit")
    private List<CommandeItem> commandeItems;

}
