package pi.vezbe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.model.City;
import pi.vezbe.model.Country;
import pi.vezbe.service.CityService;
import pi.vezbe.service.CountryService;


@RestController
@RequestMapping(value = "/api/countries")
public class ContryController {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "getCountries", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getCountries() {
		List<Country> countries = countryService.findAll();
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Country country = countryService.findOne(id);
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(country, HttpStatus.OK);
	}

	@RequestMapping(value = "addCountry", method = RequestMethod.POST)
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		country.setCode(country.getCode().trim());
		country.setName(country.getName().trim());
		Country c = countryService.save(country); // jer mora da reira novi id
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@RequestMapping(value = "removeCountry/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Country> removeCountry(@PathVariable Long id) {
		Country country = countryService.findOne(id);
		for(City c : country.getCities()) {
			cityService.delete(c.getId());
		}
		countryService.delete(id);
		return new ResponseEntity<>(countryService.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "editCountry/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> editCountry(@RequestBody Country country, @PathVariable("id") Long id) {
		Country retVal = country;
		if (countryService.findOne(id) == null) {
			retVal = countryService.save(country);
		} else {
			retVal = countryService.findOne(id);
			retVal.setCode(country.getCode().trim());
			retVal.setName(country.getName().trim());
			retVal = countryService.save(retVal);
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "searchCountry/{name}/{code}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Country>> searchCountry(@PathVariable("name") String name,
			@PathVariable("code") String code) {
		List<Country> countries = countryService.findAll();
		ArrayList<Country> retVal = new ArrayList<Country>();
		for (Country c : countries) {
			if (c.getName().trim().toUpperCase().contains(name.trim().toUpperCase())
					&& c.getCode().trim().toUpperCase().contains(code.trim().toUpperCase())) {
				System.out.println("NASAO");
				retVal.add(c);
			}
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

}
