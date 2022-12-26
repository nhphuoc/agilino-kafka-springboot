package vn.agilino.workshop.kafka.consumer;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import vn.agilino.workshop.constant.KafkaGroup;
import vn.agilino.workshop.dto.FoodOrderDTO;
import vn.agilino.workshop.kafka.producer.FoodDeliveryProducer;

/**
 * Kafka consumer will listen for new messages on the given kafka topic.
 */
@Service
public class FoodDeliveryConsumer {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(FoodDeliveryProducer.class);
    private static final Set<String> ALLOWED_FOODS = Set.of("Bun Bo", "Pho Ga", "Bun Rieu Cau");

    final Map<Integer, FoodOrderDTO> orders = new ConcurrentHashMap<>();

    @KafkaListener(topics = "${spring.kafka.topic-name}",
            groupId = KafkaGroup.GROUP_STUDENT,
            containerFactory = "kafkaListenerContainerFactory")
    public void foodOrderConsumer(FoodOrderDTO foodOrderDTO) {
        LOG.info(foodOrderDTO.toString());
        // TODO store received order in orders map
        // You can add basic validation of your food order before accepting it
        // You should also verify that the food is one of ALLOWED_FOODS.
    }

    public FoodOrderDTO getOrder(int id) {
        // TODO: implement getting order from orders Map
        // You can implement a blocking solution to wait for the order to arrive.
        return null;
    }
}
