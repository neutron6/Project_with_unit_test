package com.rsn.mark1.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity

@Table(name = "Employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private LocalDate date;




}
