package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ICityRepository;
import DO.CityDO;

@Service
public class CityService {

	@Autowired
	ICityRepository citySvc;
	
	public void addCity(CityDO city) {
		citySvc.save(city);
	}
}
