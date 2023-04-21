package com.rsn.mark1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "Employee_Id")
    private int id;

    //@Column(name = "Employee_First_Name")
    private String firstName;

    //@Column(name = "Employee_Last_Name")
    private String lastName;

    //@Column(name = "Employee_Email-Id")
    private String email;

    //@Column(name = "Employee_emailid_password")
    private String password;

}
