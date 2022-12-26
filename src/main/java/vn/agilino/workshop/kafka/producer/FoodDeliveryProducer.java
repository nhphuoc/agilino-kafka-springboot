package vn.agilino.workshop.kafka.producer;

import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import vn.agilino.workshop.configuration.KafkaTopic;
import vn.agilino.workshop.dto.FoodOrderDTO;

/**
 * Kafka Producer will receive a message and send it to a given kafka topic.
 */
@Service
public class FoodDeliveryProducer {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(FoodDeliveryProducer.class);
    private static final String DEFAULT_TOPIC_NAME = "change-me";
    private final KafkaTemplate<String, FoodOrderDTO> kafkaTemplate;
    private final KafkaTopic kafkaTopic;

    public FoodDeliveryProducer(KafkaTemplate<String, FoodOrderDTO> kafkaTemplate,
            KafkaTopic kafkaTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopic = kafkaTopic;
    }

    public void sendMessage(FoodOrderDTO foodOrderDTO) {
        if (kafkaTopic.getTopicName().equals(DEFAULT_TOPIC_NAME)) {
            LOG.error("change topic name in application.yml");
            throw new RuntimeException("Topic name not configured in application.yml");
        } else {
            kafkaTemplate.send(kafkaTopic.getTopicName(), foodOrderDTO);
        }
    }
}
