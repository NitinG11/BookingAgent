package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="CITY_SEQ", sequenceName="city_sequence")
public class CityDO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CITY_SEQ")
	private int id;
	private String cityName;
	
	@OneToMany(mappedBy = "city")
	private List<HotelDO> hotels;

	@ManyToOne
	private CountryDO country;
	
	public CityDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CityDO(int id, String cityName, List<HotelDO> hotel, CountryDO country) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.hotels = hotel;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<HotelDO> getHotel() {
		return hotels;
	}

	public void setHotel(List<HotelDO> hotel) {
		this.hotels = hotel;
	}

	public CountryDO getCountry() {
		return country;
	}

	public void setCountry(CountryDO country) {
		this.country = country;
	}
	
	
}
