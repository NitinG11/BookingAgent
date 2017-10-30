package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VO.AmenitiesVO;
import VO.HotelVO;
import model.AmenitiesDO;
import model.HotelDO;
import responses.ServiceResultVO;
import services.CityService;
import services.CountryService;
import services.HotelService;

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
		AmenitiesDO amenitiesDO = new AmenitiesDO();
		amenitiesDO.setHotel(hotelDO);
		List<AmenitiesDO> amentitiesList = new ArrayList<AmenitiesDO>();
		for(AmenitiesVO amenties : hotelVO.getAmenitites()) {
//			amentitiesList.add(e)
		}
		
		
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
	
	@RequestMapping(value = "/hotels", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<ServiceResultVO<HotelDO>> getHotels(@RequestParam(value="cityName") String city) {
		ServiceResultVO<HotelDO> oServiceResultVO = new ServiceResultVO<HotelDO>();
		List<HotelDO> hotels = hotelSvc.findByCity(city,true);
		System.out.println(hotels.size());
		return null;
		
		
	}
}
