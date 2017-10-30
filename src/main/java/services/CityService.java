package services;

import java.util.List;

import model.CityDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ICityRepository;

@Service
public class CityService {

	@Autowired
	ICityRepository citySvc;
	
	public CityDO addCity(CityDO city) {
		return citySvc.save(city);
	}
	
	public CityDO findByName(String cityName) {
		return citySvc.findByCityName(cityName);
	}
	
	public List<CityDO> findByCountry(String country) {
		return citySvc.findByCountryCountryName(country);
	}
}
