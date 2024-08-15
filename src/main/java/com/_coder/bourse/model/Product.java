package com._coder.bourse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
@SuperBuilder
@NoArgsConstructor
public class Product extends AbstractEntity {

    private String designation;

    private String status;

    private BigDecimal price;

    private String description;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "production-id")
    private Production production;

    @ManyToOne
    @JoinColumn(name = "category-id")
    private Category category;
}
