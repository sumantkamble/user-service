package com.sk.userservice.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "USERNAME" }),
        @UniqueConstraint(columnNames = { "EMAIL" })})
public class User {

    @Id @NotNull @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long id;

    @NotNull
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name="LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name="USERNAME")
    private String username;

    @NotNull
    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMAIL")
    private String email;

}
