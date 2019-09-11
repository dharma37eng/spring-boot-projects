package com.infy.weather.init;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.infy.weather.repository.WeatherRepository;
import com.infy.weather.vo.Location;
import com.infy.weather.vo.Weather;

public class DataInit implements ApplicationRunner {

	@Autowired
	private WeatherRepository weatherRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = weatherRepository.count();
		if(count == 0) {
			Weather weather = new Weather();
			Location location = new Location();
			location.setCityName("Illinois");
			location.setLatitude(36.1189f);
			location.setLongitude(-86.1195f);
			location.setStateName("Chicago");
			weather.setTemperature(new Float[] {45.3f, 44.2f});
			weather.setLocation(location);
			weather.setDateRecorded(new Date());
		}
		
	}

}
