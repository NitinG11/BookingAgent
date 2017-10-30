package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VO.CityVO;
import model.CityDO;
import model.CountryDO;
import responses.ServiceResultVO;
import responses.StatusCodes;
import services.CityService;
import services.CountryService;

@RestController
@RequestMapping(value= "/city")
public class CityController {

	@Autowired
	CountryService countrySvc;
	
	@Autowired
	CityService citySvc;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<ServiceResultVO<CityDO>> createCountry(@RequestBody CityVO cityVO) {
		CityDO oCityDO = new CityDO();
		CountryDO country = null;
		ServiceResultVO<CityDO> oServiceResult = new ServiceResultVO<CityDO>();
		try{
			country = countrySvc.findByName(cityVO.getCountryName());
			if(null != country) {
				oCityDO.setCityName(cityVO.getCityName());
				oCityDO.setCountry(countrySvc.findByName(cityVO.getCountryName()));
				oCityDO = citySvc.addCity(oCityDO);
				
				oServiceResult.setStatus(StatusCodes.OK.getDescription());
				oServiceResult.setStatusCode(StatusCodes.OK.getCode());
				oServiceResult.setData(oCityDO);
				
			} else {
				oServiceResult.setStatus(StatusCodes.BAD_REQUEST.getDescription());
				oServiceResult.setStatusCode(StatusCodes.BAD_REQUEST.getCode());
				oServiceResult.setData(null);
			}
		}catch(Exception e) {
			oServiceResult.setStatus(StatusCodes.INTERNAL_SERVER_ERROR.getDescription());
			oServiceResult.setStatusCode(StatusCodes.INTERNAL_SERVER_ERROR.getCode());
			oServiceResult.setData(null);
		}
		return new HttpEntity<ServiceResultVO<CityDO>>(oServiceResult);
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
