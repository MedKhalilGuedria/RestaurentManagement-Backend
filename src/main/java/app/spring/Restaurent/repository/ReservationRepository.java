package app.spring.Restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.spring.Restaurent.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}