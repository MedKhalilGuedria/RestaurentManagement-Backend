package app.spring.Restaurent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.spring.Restaurent.models.Delivery;
import app.spring.Restaurent.models.Order;
import app.spring.Restaurent.repository.OrderRepository;
import app.spring.Restaurent.services.DeliveryService;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;
    
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/demande")
    public ResponseEntity<Delivery> demanderLivraison(@RequestParam Long orderId,
                                                       @RequestParam String deliveryAddress) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Delivery delivery = deliveryService.demanderLivraison(order, deliveryAddress);
        return ResponseEntity.ok(delivery);
    }

    @PutMapping("/validation/{deliveryId}")
    public ResponseEntity<Delivery> validerLivraison(@PathVariable Long deliveryId,
                                                      @RequestParam int estimatedDeliveryTimeByAdmin) {
        Delivery delivery = deliveryService.validerLivraison(deliveryId, estimatedDeliveryTimeByAdmin);
        if (delivery != null) {
            return ResponseEntity.ok(delivery);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

