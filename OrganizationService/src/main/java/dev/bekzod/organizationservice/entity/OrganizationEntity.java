package dev.bekzod.organizationservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organization")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
