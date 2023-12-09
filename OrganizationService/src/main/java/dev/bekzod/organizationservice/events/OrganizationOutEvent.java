package dev.bekzod.organizationservice.events;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationOutEvent {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.application.name}")
    String application;

    public void publishOrganizationChanges(final String data) {
        kafkaTemplate.send(application, data);
    }
}
