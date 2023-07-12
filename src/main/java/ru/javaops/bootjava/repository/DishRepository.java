package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.error.DataConflictException;
import ru.javaops.bootjava.model.Dish;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DishRepository extends BaseRepository<Dish>{

    @Query("SELECT d FROM Dish d WHERE d.date = current_date ORDER BY d.id DESC")
    List<Dish> getAll();

    @Query("SELECT d FROM Dish d WHERE d.id = :id AND d.date = current_date")
    Optional<Dish> get(int id);

    default Dish getExistedOrBelonged(int id) {
        return get(id).orElseThrow(
                () -> new DataConflictException("Dish id=" + id + " is not exist"));
    }
}
