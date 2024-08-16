package com._coder.bourse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "council")
@SuperBuilder
@NoArgsConstructor
public class Council extends AbstractEntity{

    private String councilName;
    private String mayorName;
    private String superMayorName;
    private String country;
    private String email;
    private Long population;
    private BigDecimal area;
    private String region;
    private String postalCode;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String economicPotential;
    private String ImagePath;

    private String matriculeCommunale;

    @OneToMany(mappedBy = "council")
    private List<Product> products;

    

}
