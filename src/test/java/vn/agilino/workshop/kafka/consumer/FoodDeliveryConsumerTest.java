package vn.agilino.workshop.kafka.consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.agilino.workshop.dto.FoodOrderDTO;

class FoodDeliveryConsumerTest {

    @Test
    void foodOrderConsumer() {
        // given a delivery order
        FoodOrderDTO deliveryDTO = new FoodOrderDTO();
        deliveryDTO.setId(2);
        deliveryDTO.setAddress("Can Tho University");
        deliveryDTO.setFoodName("Bun Rieu Cua");

        FoodDeliveryConsumer foodDeliveryConsumer = new FoodDeliveryConsumer();
        foodDeliveryConsumer.foodOrderConsumer(deliveryDTO);
        Assertions.assertEquals(2, foodDeliveryConsumer.getOrder(2).getId());
    }

    @Test
    void getOrder() {
        // given a delivery order
        FoodOrderDTO deliveryDTO = new FoodOrderDTO();
        deliveryDTO.setId(1);
        deliveryDTO.setAddress("Can Tho University");
        deliveryDTO.setFoodName("Pho Ga");
        // when we process the order
        FoodDeliveryConsumer foodDeliveryConsumer = new FoodDeliveryConsumer();
        foodDeliveryConsumer.foodOrderConsumer(deliveryDTO);
        // then we get a result
        Assertions.assertEquals("Pho Ga", foodDeliveryConsumer.getOrder(1).getFoodName());
    }

    @Test
    void getOrder_prevent_duplicate() {
        // given a delivery order
        FoodDeliveryConsumer foodDeliveryConsumer = new FoodDeliveryConsumer();
        FoodOrderDTO deliveryDTO = new FoodOrderDTO();
        deliveryDTO.setId(3);
        deliveryDTO.setAddress("Can Tho University");
        deliveryDTO.setFoodName("Bun Bo");
        // when we process the order first time
        foodDeliveryConsumer.foodOrderConsumer(deliveryDTO);
        // then we get a result
        Assertions.assertEquals("Bun Bo", foodDeliveryConsumer.getOrder(3).getFoodName());
        // but we not get it again
        Assertions.assertNull(foodDeliveryConsumer.getOrder(3));
    }

    @Test
    void getOrder_prevent_not_allowed_food() {
        // given a delivery order
        FoodDeliveryConsumer foodDeliveryConsumer = new FoodDeliveryConsumer();
        FoodOrderDTO deliveryDTO = new FoodOrderDTO();
        deliveryDTO.setId(3);
        deliveryDTO.setAddress("Can Tho University");
        deliveryDTO.setFoodName("Com ga");
        // when we process the order first time
        foodDeliveryConsumer.foodOrderConsumer(deliveryDTO);

        // then we get a result
        Assertions.assertNull(foodDeliveryConsumer.getOrder(3));
    }
}