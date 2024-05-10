package app.spring.Restaurent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.Restaurent.models.Dish;
import app.spring.Restaurent.repository.DishRepository;

@Service
public class MenuService {

    @Autowired
    private DishRepository dishRepository;

    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish updateDish(Long dishId, Dish updatedDish) {
        Dish existingDish = dishRepository.findById(dishId).orElse(null);
        if (existingDish != null) {
            existingDish.setName(updatedDish.getName());
            existingDish.setDescription(updatedDish.getDescription());
            existingDish.setPrice(updatedDish.getPrice());
            existingDish.setPreparationTime(updatedDish.getPreparationTime());
            return dishRepository.save(existingDish);
        }
        return null; // or throw an exception
    }

    public void deleteDish(Long dishId) {
        dishRepository.deleteById(dishId);
    }
}
