package app.spring.Restaurent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.spring.Restaurent.models.Panier;
import app.spring.Restaurent.services.PanierService;

@RestController
@RequestMapping("/api/panier")
public class PanierController {

    @Autowired
    private PanierService panierService;

    @PostMapping("/add")
    public ResponseEntity<?> addToPanier(@RequestParam Long userId, @RequestParam Long dishId, @RequestParam int quantity) {
        panierService.addToPanier(userId, dishId, quantity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFromPanier(@RequestParam Long userId, @RequestParam Long dishId) {
        panierService.removeFromPanier(userId, dishId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearPanier(@RequestParam Long userId) {
        panierService.clearPanier(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Panier> getPanier(@PathVariable Long userId) {
        Panier panier = panierService.getPanier(userId);
        if (panier != null) {
            return ResponseEntity.ok(panier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
