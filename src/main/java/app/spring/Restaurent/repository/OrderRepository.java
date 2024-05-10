package app.spring.Restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.spring.Restaurent.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

