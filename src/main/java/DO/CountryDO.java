package DO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="COUNTRY_SEQ", sequenceName="country_sequence")
public class CountryDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="COUNTRY_SEQ")
	private int id;
	private String countryName;
	
	/*@OneToMany(mappedBy = "city")
	private List<HotelDO> hotels = new ArrayList<HotelDO>(0);*/
	
	@OneToMany(mappedBy = "country")
	private List<CityDO> cities = new ArrayList<CityDO>(0);

	public CountryDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryDO(int id, String countryName,
			List<CityDO> cities) {
		super();
		this.id = id;
		this.countryName = countryName;
//		this.hotels = hotels;
		this.cities = cities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return countryName;
	}

	public void setCityName(String cityName) {
		this.countryName = cityName;
	}

	/*public List<HotelDO> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelDO> hotels) {
		this.hotels = hotels;
	}*/

	public List<CityDO> getCities() {
		return cities;
	}

	public void setCities(List<CityDO> cities) {
		this.cities = cities;
	}
	
	
}
