package io.sb.movieappservice.dao;

import io.sb.movieappservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieDao extends JpaRepository<Movie, Integer> {
}
