package com.infy.weather.controller;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infy.weather.repository.WeatherRepository;
import com.infy.weather.vo.Weather;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherRepository weatherRepository;



	@GetMapping("/weather")
	public List<Weather> findAll() {
		Comparator<Weather> comp = Comparator.comparing(Weather::getId);
		return weatherRepository.findAll().stream().sorted(comp).collect(Collectors.toList());
	}

	@PostMapping("/weather")
	public ResponseEntity<Weather> saveWeather(@RequestBody Weather weather) {
		Weather savedObj = weatherRepository.save(weather);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedObj.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/weather/{id}")
	public void updateWeather(@RequestBody Weather weather, @PathVariable long id) {
		Optional<Weather> findById = weatherRepository.findById(id);
		if(findById.isPresent()) {
			weatherRepository.save(weather); 
		} else {
			weather.setId(id);
			weatherRepository.save(weather);
		}
	}

	@DeleteMapping("delete-weather/{id}")
	public void deleteWeather(@PathVariable long id) {
		if(id <= 0) {
			throw new RuntimeException();
		}
			weatherRepository.deleteById(id);
	}
	
	@DeleteMapping("delete-all")
	public void deleteAllWeather() {
		weatherRepository.deleteAll();
	}
}
