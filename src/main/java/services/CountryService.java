package services;

import model.CountryDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ICountryRepository;

@Service
public class CountryService {

	@Autowired
	ICountryRepository countryRepo;
	
	public boolean createCountry(CountryDO country) {
		countryRepo.save(country);
		return true;
	}
	
	public CountryDO findByName(String name) {
		return countryRepo.findByCountryName(name);
	}
}
