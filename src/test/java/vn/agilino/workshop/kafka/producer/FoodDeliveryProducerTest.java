package vn.agilino.workshop.kafka.producer;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import vn.agilino.workshop.TestKafkaTemplate;
import vn.agilino.workshop.configuration.KafkaTopic;
import vn.agilino.workshop.dto.FoodOrderDTO;

@SpringBootTest
class FoodDeliveryProducerTest {

    @Autowired
    KafkaTopic kafkaTopic;

    @Test
    void sendMessage() {
        TestKafkaTemplate<String, FoodOrderDTO> template = new TestKafkaTemplate<>(new DefaultKafkaProducerFactory(
                Map.of(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "example.com")), false);
        FoodDeliveryProducer foodDeliveryProducer = new FoodDeliveryProducer(template, kafkaTopic);
        FoodOrderDTO dto = new FoodOrderDTO();
        dto.setAddress("Agilino");
        Assertions.assertDoesNotThrow(() -> foodDeliveryProducer.sendMessage(dto));
    }
}