package dev.bekzod.organizationservice.configurations;

import dev.bekzod.organizationservice.components.MicrometerKafkaSender;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.Sender;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(KafkaProperties.class)
@ConditionalOnClass(ByteArraySerializer.class)
@ConditionalOnExpression(value = "${management.tracing.enabled:true} and ${management.zipkin.tracing.kafka-sender.enabled:false}")
public class ZipkinSenderConfiguration {

    @Bean
    public Sender kafkaSender(KafkaProperties kafkaProperties) {
        return MicrometerKafkaSender
                .newBuilder()
                .bootstrapServers(String.join(",", kafkaProperties.getBootstrapServers()))
                .topic(kafkaProperties.getClientId())
                .build();
    }
}
