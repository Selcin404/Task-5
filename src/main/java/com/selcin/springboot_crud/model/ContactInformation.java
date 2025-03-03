package com.selcin.springboot_crud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String alternateEmail;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
