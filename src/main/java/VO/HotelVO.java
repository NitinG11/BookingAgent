package VO;

import java.util.List;

public class HotelVO {

	private String hotelName;
	private String description;
	private String cityName;
	private String countryName;
	private double latitude;
	private double longitude;
	private List<ContactVO> contacts;
	private List<AmenitiesVO> amenitites;
	private AddressVO address;
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public List<ContactVO> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactVO> contacts) {
		this.contacts = contacts;
	}
	public List<AmenitiesVO> getAmenitites() {
		return amenitites;
	}
	public void setAmenitites(List<AmenitiesVO> amenitites) {
		this.amenitites = amenitites;
	}
	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	
}
