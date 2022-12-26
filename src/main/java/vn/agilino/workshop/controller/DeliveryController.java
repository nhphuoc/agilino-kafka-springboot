package vn.agilino.workshop.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.agilino.workshop.dto.FoodOrderDTO;
import vn.agilino.workshop.kafka.producer.FoodDeliveryProducer;

/**
 * REST Controller for the food delivery company to send food to the customers.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DeliveryController {
    private final FoodDeliveryProducer producer;

    public DeliveryController(FoodDeliveryProducer producer) {
        this.producer = producer;
    }

    @PostMapping(path = "/deliver")
    public ResponseEntity<Void> sendKafKaMessage(@RequestBody FoodOrderDTO foodOrderDTO) {
        producer.sendMessage(foodOrderDTO);
        return ResponseEntity.noContent().build();
    }
}
