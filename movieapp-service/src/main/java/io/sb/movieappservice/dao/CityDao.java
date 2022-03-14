package io.sb.movieappservice.dao;

import io.sb.movieappservice.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
    public City findByCityName(String cityName);
}
