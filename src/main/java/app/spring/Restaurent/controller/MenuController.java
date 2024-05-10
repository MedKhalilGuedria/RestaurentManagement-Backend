package app.spring.Restaurent.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.spring.Restaurent.models.Dish;
import app.spring.Restaurent.services.MenuService;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/addDish")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        Dish newDish = menuService.addDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDish);
    }

    @PutMapping("/updateDish/{dishId}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long dishId, @RequestBody Dish updatedDish) {
        Dish updated = menuService.updateDish(dishId, updatedDish);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteDish/{dishId}")
    public ResponseEntity<?> deleteDish(@PathVariable Long dishId) {
        menuService.deleteDish(dishId);
        return ResponseEntity.ok().build();
    }
}
