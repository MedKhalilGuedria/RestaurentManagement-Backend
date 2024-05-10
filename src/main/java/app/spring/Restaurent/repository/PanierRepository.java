package app.spring.Restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.spring.Restaurent.models.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {
}
