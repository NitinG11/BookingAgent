package controllers;

import model.CountryDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import services.CountryService;
import VO.CountryVO;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	CountryService countrySvc;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCountry(@RequestBody CountryVO countryVO) {
		// vo-do convertor
		CountryDO country = new CountryDO();
		country.setCityName(countryVO.getCountryName());
		try {
			if (countrySvc.createCountry(country))
				return new ResponseEntity<String>("Created country",
						HttpStatus.CREATED);
			else
				return new ResponseEntity<String>("Created country",
						HttpStatus.BAD_REQUEST);
		} catch (Exception exception) {
			return new ResponseEntity<String>("Country creation failed",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public ResponseEntity<String> retrieveCountry() {

		return new ResponseEntity<String>("No countries available",
				HttpStatus.NOT_FOUND);

	}

}
