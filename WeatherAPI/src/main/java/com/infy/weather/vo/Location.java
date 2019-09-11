package com.infy.weather.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Location {
	@Column(name = "cityName")
	private String cityName;
	@Column(name = "stateName")
	private String stateName;
	@Column(name = "latitude")
	private Float latitude;
	@Column(name = "longitude")
	private Float longitude;

	public Location() {
	}

	public Location(String cityName, String stateName, Float latitude, Float longitude) {
		this.cityName = cityName;
		this.stateName = stateName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Location [cityName=" + cityName + ", stateName=" + stateName + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}


}
