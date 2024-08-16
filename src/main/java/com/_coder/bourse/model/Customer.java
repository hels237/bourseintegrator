package com._coder.bourse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "customer")
@SuperBuilder
@NoArgsConstructor
public class Customer extends AbstractEntity {

    private String firstName;

    private String lastName;

    private String email;
}
