package com.example.be.repositories;

import com.example.be.models.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    ShowTime findById(int id);

    ShowTime findByIdAndStatus(int id, int status);

    List<ShowTime> findByStatus(int status);

    List<ShowTime> findByMovieId(int id);

    @Query("SELECT DISTINCT DATE(st.startTime) FROM ShowTime st WHERE st.movie.id = :movieId")
    List<Date> findDistinctStartDatesByMovieId(int movieId);

}

