package ru.javaops.bootjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.model.Dish;
import ru.javaops.bootjava.repository.DishRepository;

@Service
@AllArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    @Transactional
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }
}

