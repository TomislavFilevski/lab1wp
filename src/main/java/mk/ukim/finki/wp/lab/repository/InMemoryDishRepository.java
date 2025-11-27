package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryDishRepository implements DishRepository {

    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.stream()
                .filter(dish -> dish.getDishId().equals(dishId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return DataHolder.dishes.stream()
                .filter(dish -> dish.getId().equals(id))
                .findFirst();
    }

    @Override
    public Dish save(Dish dish) {
        if (dish.getId() != null) {
            DataHolder.dishes.removeIf(d -> d.getId().equals(dish.getId()));
        } else {
            Long newId = DataHolder.dishes.stream()
                    .mapToLong(Dish::getId)
                    .max()
                    .orElse(0L) + 1;
            dish.setId(newId);
        }
        DataHolder.dishes.add(dish);
        return dish;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.dishes.removeIf(dish -> dish.getId().equals(id));
    }
}