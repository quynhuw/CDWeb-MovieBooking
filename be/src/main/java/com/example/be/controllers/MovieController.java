package com.example.be.controllers;

import com.example.be.dto.MovieDTO;
import com.example.be.models.Movie;
import com.example.be.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll() {
        return new ResponseEntity<>(movieService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        return new ResponseEntity<>(movieService.singleMovie(id), HttpStatus.OK);
    }

    //Get movies by type (Coming/Showing Movie)
    @GetMapping("/type")
    public ResponseEntity<List<Movie>> getMoviesByType(@RequestParam String type) {
        return new ResponseEntity<>(movieService.getMoviesByType(type), HttpStatus.OK);
    }
    @GetMapping("/search")
    public List<Movie> searchProducts(@RequestParam("query") String query) {
        return movieService.searchProducts(query);
//        return null;
    }
}
