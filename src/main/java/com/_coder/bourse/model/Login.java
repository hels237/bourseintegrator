package com._coder.bourse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "log-in")
@SuperBuilder
@NoArgsConstructor
public class Login extends AbstractEntity{

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "user-id")
    private User user;
}
