package com._coder.bourse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "_user")
@SuperBuilder
@NoArgsConstructor
public class User extends AbstractEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private Boolean isEnabled;

    @Enumerated(EnumType.STRING)
    private Role role;

}
