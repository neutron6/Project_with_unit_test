package com.rsn.mark1.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Employee_Record_Data")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_Id")
    private int id;

    @Column(name = "Employee_First_Name")
    private String firstName;

    @Column(name = "Employee_Last_Name")
    private String lastName;

    @Column(name = "Employee_Email-Id")
    private String email;

    @Column(name = "Employee_emailid_password")
    private String password;

}
