package dev.bekzod.courierservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courier")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int organizationId;
}
