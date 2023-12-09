package dev.bekzod.courierservice.feignclients;

import dev.bekzod.courierservice.entity.OrganizationHash;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${application.organization}")
public interface OrganizationFeign {

    @GetMapping("/organizations")
    List<OrganizationHash> getOrganizations();

}
