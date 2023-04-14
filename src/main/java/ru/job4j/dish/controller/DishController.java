package ru.job4j.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.service.DishService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dish")
@AllArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping("/")
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        Dish dish = dishService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dish is not found. Please, check id."));
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Dish> create(@Valid @RequestBody Dish dish) {
        return new ResponseEntity<>(dishService.save(dish), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody Dish dish) {
        dishService.findById(dish.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dish can't be update. It not found by id."));
        dishService.save(dish);
        return ResponseEntity.ok("Dish update was successful");
    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(@Valid @RequestBody Dish dish) {
        dishService.findById(dish.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dish can't be delete. It not found by id."));
        dishService.delete(dish);
        return ResponseEntity.ok("Dish delete was successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        dishService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dish can't be delete. It not found by id."));
        dishService.deleteById(id);
        return ResponseEntity.ok("Dish delete was successful");
    }

}
