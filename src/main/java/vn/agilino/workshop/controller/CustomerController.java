package vn.agilino.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.agilino.workshop.dto.FoodOrderDTO;
import vn.agilino.workshop.kafka.consumer.FoodDeliveryConsumer;

/**
 * Let customer receive food by getting it from {@link FoodDeliveryConsumer#getOrder(int)}
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    FoodDeliveryConsumer foodDeliveryConsumer;

    @GetMapping("/receive")
    public FoodOrderDTO getFood(@RequestParam int id) {
        return foodDeliveryConsumer.getOrder(id);
    }
}
