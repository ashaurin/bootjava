package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.error.DataConflictException;
import ru.javaops.bootjava.model.Restaurant;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant>{

    @Query("SELECT r FROM Restaurant r ORDER BY r.id DESC")
    List<Restaurant> getAll();

    @Query("SELECT r FROM Restaurant r WHERE r.id = :id")
    Optional<Restaurant> get(int id);

    default Restaurant getExistedOrBelonged(int id) {
        return get(id).orElseThrow(
                () -> new DataConflictException("Restaurant id=" + id + " is not exist"));
    }

}
