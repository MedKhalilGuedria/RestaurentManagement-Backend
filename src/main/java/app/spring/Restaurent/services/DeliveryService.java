package app.spring.Restaurent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.Restaurent.models.Delivery;
import app.spring.Restaurent.models.Order;
import app.spring.Restaurent.repository.DeliveryRepository;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery demanderLivraison(Order order, String deliveryAddress) {
        Delivery delivery = new Delivery(deliveryAddress, "En attente", 0, order); // Le temps de livraison estimé est initialement 0
        return deliveryRepository.save(delivery);
    }

    public Delivery validerLivraison(Long deliveryId, int estimatedDeliveryTimeByAdmin) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElse(null);
        if (delivery != null) {
            delivery.setStatus("Validée");
            delivery.setEstimatedDeliveryTime(estimatedDeliveryTimeByAdmin);
            return deliveryRepository.save(delivery);
        }
        return null;
    }
}
