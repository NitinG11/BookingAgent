package controllers;

import java.util.List;

import model.CityDO;

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

import responses.ServiceResultVO;
import services.CityService;
import services.CountryService;
import VO.CityVO;

@RestController
@RequestMapping(value= "/city")
public class CityController {

	@Autowired
	CountryService countrySvc;
	
	@Autowired
	CityService citySvc;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCountry(@RequestBody CityVO cityVO) {
		CityDO oCityDO = new CityDO();
		oCityDO.setCityName(cityVO.getCityName());
		oCityDO.setCountry(countrySvc.findByName(cityVO.getCountryName()));
		citySvc.addCity(oCityDO);
		return new ResponseEntity<String>("City Associated", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getCities", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<ServiceResultVO<CityDO>> findCities(@RequestParam(value="countryName") String countryName) {
		ServiceResultVO<CityDO> oServiceResultVO = new ServiceResultVO<CityDO>();
		List<CityDO> city = citySvc.findByCountry(countryName);
		System.out.println(city.get(0).getCityName());
		oServiceResultVO.setStatusCode(HttpStatus.OK.value());;
		oServiceResultVO.setData(city.get(0));
		return new HttpEntity(oServiceResultVO);
	}
}
