package com.selcin.springboot_crud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String district;
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
