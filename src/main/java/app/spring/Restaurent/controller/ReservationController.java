package app.spring.Restaurent.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.spring.Restaurent.models.Reservation;
import app.spring.Restaurent.models.Table;
import app.spring.Restaurent.models.User;
import app.spring.Restaurent.repository.ReservationRepository;
import app.spring.Restaurent.repository.TableRepository;
import app.spring.Restaurent.repository.UserRepository;
import app.spring.Restaurent.services.ReservationService;

import java.util.Date;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/make")
    public ResponseEntity<?> makeReservation(@RequestParam Long userId,
                                              @RequestParam Long tableId,
                                              @RequestParam Date reservationDate,
                                              @RequestParam int numberOfPeople) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

        Table table = tableRepository.findById(tableId).orElse(null);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Table not found");
        }

        Reservation reservation = reservationService.makeReservation(user, table, reservationDate, numberOfPeople);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Table is already reserved");
        }
    }
}
