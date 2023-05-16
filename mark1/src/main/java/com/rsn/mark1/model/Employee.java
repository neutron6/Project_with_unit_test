package com.rsn.mark1.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;



}
