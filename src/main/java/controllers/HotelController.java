package controllers;

import model.HotelDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import services.CityService;
import services.CountryService;
import services.HotelService;
import VO.HotelVO;

@RestController
@RequestMapping(value= "/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelSvc;
	
	@Autowired
	CountryService countrySvc;
	
	@Autowired
	CityService citySvc;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCountry(@RequestBody HotelVO hotelVO) {
		HotelDO hotelDO = new HotelDO();
		hotelDO.setCity(citySvc.findByName(hotelVO.getCityName()));
		hotelDO.setCountry(countrySvc.findByName(hotelVO.getCountryName()));
		hotelDO.setAmenities(null);
		hotelDO.setContacts(null);
		hotelDO.setDescription("Located in central Mumbai");
		hotelDO.setLatitiude(10.23);
		hotelDO.setLongitude(87.36);
		hotelDO.setName("Casablanca");
		hotelSvc.addHotel(hotelDO);
		return new ResponseEntity<String>("Hotel Created", HttpStatus.CREATED);
	}
	
}
