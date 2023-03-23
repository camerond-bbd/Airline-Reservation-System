package co.za.bbd.ars.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
public class Airport {
    
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airportId;
	
	@NotNull
        @Size(min = 4, message = "Name should have at least 4 characters")
	private String airName;
	
	@NotNull
	@Size(min = 4, message = "City should have at least 4 characters")
	private String city;
	
	@NotNull
	@Size(min = 4, message = "Country should have at least 4 characters")
	private String country;
	
	public Airport(int airportId, String airName, String city, String country) {
		super();
		this.airportId = airportId;
		this.airName = airName;
		this.city = city;
		this.country = country;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(airName, airportId, city, country);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		return Objects.equals(airName, other.airName) && airportId == other.airportId
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country);
	}

	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airName=" + airName + ", city=" + city + ", country=" + country
				+ "]";
	}
	
	
	
}
