package app.spring.Restaurent.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import app.spring.Restaurent.models.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
