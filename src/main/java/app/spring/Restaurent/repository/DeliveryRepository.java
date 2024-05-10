package app.spring.Restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.spring.Restaurent.models.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}