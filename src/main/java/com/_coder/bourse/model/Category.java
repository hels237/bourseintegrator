package com._coder.bourse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
@SuperBuilder
@NoArgsConstructor
public class Category  extends AbstractEntity{

    private String categoryName;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products ;
}
