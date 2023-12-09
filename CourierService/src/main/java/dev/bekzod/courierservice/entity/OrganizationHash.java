package dev.bekzod.courierservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ORGANIZATION")
public class OrganizationHash {

    @Id
    private int id;

    private String name;
}
