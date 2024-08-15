package com._coder.bourse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "production")
@SuperBuilder
@NoArgsConstructor
public class Production extends AbstractEntity{

    private Integer qte;

    private String season;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    @OneToMany(mappedBy = "production")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "council-id")
    private Council council;
}
