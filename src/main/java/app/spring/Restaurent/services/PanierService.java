package app.spring.Restaurent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.Restaurent.models.Dish;
import app.spring.Restaurent.models.Panier;
import app.spring.Restaurent.models.PanierItem;
import app.spring.Restaurent.models.User;
import app.spring.Restaurent.repository.DishRepository;
import app.spring.Restaurent.repository.PanierRepository;
import app.spring.Restaurent.repository.UserRepository;

@Service
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DishRepository dishRepository;

    public void addToPanier(Long userId, Long dishId, int quantity) {
        User user = userRepository.findById(userId).orElse(null);
        Dish dish = dishRepository.findById(dishId).orElse(null);

        if (user != null && dish != null) {
            Panier panier = user.getPanier();
            if (panier == null) {
                panier = new Panier();
                panier.setUser(user);
                user.setPanier(panier);
            }

            boolean dishAlreadyInCart = panier.getItems().stream()
                                            .anyMatch(item -> item.getDish().getId().equals(dishId));
            if (dishAlreadyInCart) {
                panier.getItems().stream()
                    .filter(item -> item.getDish().getId().equals(dishId))
                    .findFirst()
                    .ifPresent(item -> item.setQuantity(item.getQuantity() + quantity));
            } else {
                panier.getItems().add(new PanierItem(dish, quantity));
            }

            panierRepository.save(panier);
        }
    }

    public void removeFromPanier(Long userId, Long dishId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            Panier panier = user.getPanier();
            if (panier != null) {
                panier.getItems().removeIf(item -> item.getDish().getId().equals(dishId));
                panierRepository.save(panier);
            }
        }
    }

    public void clearPanier(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            Panier panier = user.getPanier();
            if (panier != null) {
                panier.getItems().clear();
                panierRepository.save(panier);
            }
        }
    }

    public Panier getPanier(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            return user.getPanier();
        }
        return null;
    }
}