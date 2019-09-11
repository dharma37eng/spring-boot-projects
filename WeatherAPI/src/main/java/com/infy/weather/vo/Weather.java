package com.infy.weather.vo;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
	@Column(name = "dateRecorded")
    private Date dateRecorded;
    @Embedded
    @Column(name = "location")
    private Location location;
    @Column(name = "temperature")
    private Float[] temperature;

    public Weather() {
    }

    public Weather(Long id, Date dateRecorded, Location location, Float[] temperature) {
        this.id = id;
        this.dateRecorded = dateRecorded;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRecorded == null) ? 0 : dateRecorded.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + Arrays.hashCode(temperature);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (dateRecorded == null) {
			if (other.dateRecorded != null)
				return false;
		} else if (!dateRecorded.equals(other.dateRecorded))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (!Arrays.equals(temperature, other.temperature))
			return false;
		return true;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float[] getTemperature() {
        return temperature;
    }

    public void setTemperature(Float[] temperature) {
        this.temperature = temperature;
    }

	@Override
	public String toString() {
		return "Weather [id=" + id + ", dateRecorded=" + dateRecorded + ", location=" + location + ", temperature="
				+ Arrays.toString(temperature) + "]";
	}
    
    
}
