package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import VO.CountryVO;
import model.CountryDO;
import responses.ServiceResultVO;
import responses.StatusCodes;
import services.CountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	CountryService countrySvc;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<ServiceResultVO<CountryDO>> createCountry(@RequestBody CountryVO countryVO) {
		// vo-do convertor
		CountryDO country = new CountryDO();
		ServiceResultVO<CountryDO> oServiceResult = new ServiceResultVO<CountryDO>();
		country.setCityName(countryVO.getCountryName());
		try {
			country = countrySvc.createCountry(country);
			if (null != country) {
				oServiceResult.setStatus(StatusCodes.OK.getDescription());
				oServiceResult.setStatusCode(StatusCodes.OK.getCode());
				oServiceResult.setData(country);
			} else {
				oServiceResult.setStatus(StatusCodes.BAD_REQUEST.getDescription());
				oServiceResult.setStatusCode(StatusCodes.BAD_REQUEST.getCode());
				oServiceResult.setData(null);
			}

		} catch (Exception exception) {
			oServiceResult.setStatus(StatusCodes.INTERNAL_SERVER_ERROR.getDescription());
			oServiceResult.setStatusCode(StatusCodes.INTERNAL_SERVER_ERROR.getCode());
			oServiceResult.setData(null);
		}
		return new HttpEntity<ServiceResultVO<CountryDO>>(oServiceResult);
	}
}
