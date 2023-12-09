package dev.bekzod.springreactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "organization")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationEntity {

    @Id
    private int id;

    private String name;
}
