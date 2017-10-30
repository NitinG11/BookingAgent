package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HOTEL")
@SequenceGenerator(name="HOTEL_SEQ", sequenceName="hotel_sequence")
public class HotelDO {

	@Id
	@Column(name = "HOTEL_ID" , unique= true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="HOTEL_SEQ")
	private int id;
	
	@Column(name = "NAME" , nullable = false)
	private String name;
	
	@Column(name = "DESCRIPTION",nullable = false)
	private String description;
	
	@OneToOne
	private AddressDO address;
	
	@OneToMany
	private List<ContactDO> contacts;
	
	@ManyToOne
	private CityDO city;
	
	@ManyToOne
	private CountryDO country;
	
	@OneToMany(mappedBy = "hotel")
	private List<AmenitiesDO> amenities;
	
	@Column(name= "LONGITUDE", nullable = true)
	private double longitude;
	
	@Column(name= "LATITUDE", nullable = true)
	private double latitiude;
	
	@Column(name = "Active")
	private boolean active;
	
	public HotelDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelDO(int id, String name, String description, AddressDO address,
			List<ContactDO> contacts, List<AmenitiesDO> amenities,
			double longitude, double latitiude) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.contacts = contacts;
		this.amenities = amenities;
		this.longitude = longitude;
		this.latitiude = latitiude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressDO getAddress() {
		return address;
	}

	public void setAddress(AddressDO address) {
		this.address = address;
	}

	public List<ContactDO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactDO> contacts) {
		this.contacts = contacts;
	}

	public List<AmenitiesDO> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<AmenitiesDO> amenities) {
		this.amenities = amenities;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitiude() {
		return latitiude;
	}

	public void setLatitiude(double latitiude) {
		this.latitiude = latitiude;
	}

	public CityDO getCity() {
		return city;
	}

	public void setCity(CityDO city) {
		this.city = city;
	}

	public CountryDO getCountry() {
		return country;
	}

	public void setCountry(CountryDO country) {
		this.country = country;
	}
	
	
}
