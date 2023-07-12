package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.error.NotFoundException;
import ru.javaops.bootjava.model.Vote;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote>{

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.user.id = :userId AND v.date = current_date")
    int delete(int userId);

    @Query("SELECT v FROM Vote v WHERE v.date = current_date ORDER BY v.id DESC")
    List<Vote> getAll();

    @Query("SELECT v FROM Vote v WHERE v.user.id = :userId AND v.date = current_date")
    Optional<Vote> get(int userId);


    default void deleteExisted(int userId) {
        if (delete(userId) == 0) {
            throw new NotFoundException("Entity for userId=" + userId + " not found");
        }
    }

    default Vote getExisted(int userId) {
        return get(userId).
                orElseThrow(() -> new NotFoundException("Entity for userId=" + userId + " not found"));
    }

    default void checkExisted(int userId) {
        if(get(userId).isEmpty()){
            throw new NotFoundException("Entity for userId=" + userId + " not found");
        }
    }

}
