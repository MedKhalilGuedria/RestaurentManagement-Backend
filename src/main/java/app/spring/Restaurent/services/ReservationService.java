package app.spring.Restaurent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.Restaurent.models.Reservation;
import app.spring.Restaurent.models.TableEntity;
import app.spring.Restaurent.models.User;
import app.spring.Restaurent.repository.ReservationRepository;
import app.spring.Restaurent.repository.TableRepository;

import java.util.Date;


@Service
public class ReservationService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation makeReservation(User user, TableEntity table, Date reservationDate, int numberOfPeople) {
        // Vérifier si la table est disponible
        if (!table.isReserved()) {
            // Marquer la table comme réservée
            table.setReserved(true);
            tableRepository.save(table);

            // Créer une nouvelle réservation
            Reservation reservation = new Reservation();
            reservation.setUser(user);
            reservation.setTable(table);
            reservation.setReservationDate(reservationDate);
            reservation.setNumberOfPeople(numberOfPeople);
            return reservationRepository.save(reservation);
        } else {
            // Gérer la non-disponibilité de la table (ex. renvoyer null ou jeter une exception)
            return null;
        }
    }
}
