package dev.bekzod.springreactivesecondary.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "courier")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourierEntity {

    @Id
    private Integer id;

    private String name;

    private int organizationId;
}
