package dev.bekzod.courierservice.events;

import dev.bekzod.courierservice.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationInEvent {

    private final OrganizationService service;

    @KafkaListener(topics = "${application.organization}",groupId = "${application.organization}")
    public void processOrganization(final String content) {
        service.reload();
    }


}
