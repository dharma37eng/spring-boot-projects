package com.infy.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.weather.vo.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{

}
