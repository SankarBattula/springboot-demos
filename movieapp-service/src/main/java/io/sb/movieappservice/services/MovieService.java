package io.sb.movieappservice.services;

import java.util.List;

import io.sb.movieappservice.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MovieService {

  public Movie acceptMovieDetails(Movie movie);

  public List<Movie> acceptMultipleMovieDetails(List<Movie> movies);

  public Movie getMovieDetails(int id ) ;

  public Movie updateMovieDetails(int id , Movie movie);

  public boolean deleteMovie(int id);

  public List<Movie> getAllMovies();

  public Page<Movie> getPaginatedMovieDetails(Pageable pageRequest);
}
