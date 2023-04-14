package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }

    public void deleteById(int id) {
        dishRepository.deleteById(id);
    }

}
