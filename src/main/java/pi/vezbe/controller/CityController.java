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

import pi.vezbe.converters.CityDTOtoCity;
import pi.vezbe.converters.CityToCityDTO;
import pi.vezbe.DTO.CityDTO;
import pi.vezbe.model.City;
import pi.vezbe.service.CityService;
import pi.vezbe.service.CountryService;

@RestController
@RequestMapping(path="api/cities")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CityToCityDTO toCityDTO;
	
	@Autowired
	private CityDTOtoCity toCity;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="getCities/{kod}", method=RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> getCities(@PathVariable ("kod") String kod){
		if(kod.equals("ALL")){
			List<City> cities = cityService.findAll();
			return new ResponseEntity<>(toCityDTO.convert(cities), HttpStatus.OK);
		}
		List<City> cities = cityService.findByCountryCode(kod);
		return new ResponseEntity<>(toCityDTO.convert(cities), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CityDTO> addCity(@RequestBody CityDTO cityDTO){
		City newCity = cityService.save(toCity.convert(cityDTO));
		return new ResponseEntity<>(toCityDTO.convert(newCity), HttpStatus.OK);
	}
	
	@RequestMapping(value="removeCity/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<City>removeCity(@PathVariable ("id") Long Id) {
		cityService.delete(Id);
		return new ResponseEntity<>(cityService.findOne(Id), HttpStatus.OK);
	}
	
	@RequestMapping(value="edtiCity/{id}",method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityDTO>edtiCity(@PathVariable ("id") Long id, @RequestBody CityDTO cityDTO) {
		City retVal = cityService.findOne(id);
		retVal.setCode(cityDTO.getCode());
		retVal.setName(cityDTO.getName());
		retVal.setPostalCode(cityDTO.getPostalCode());
		//retVal.setCountry(countryService.findOne(cityDTO.getCountryId()));
		cityService.save(retVal);		
		return new ResponseEntity<>(toCityDTO.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(value = "searchCity", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<CityDTO>> searchCity(@RequestBody CityDTO cityDTO) {
		
		List<City> cities = cityService.findAll();
		ArrayList<CityDTO> retVal = new ArrayList<CityDTO>();
		for (City c : cities) {
			if (c.getName().trim().toUpperCase().contains(cityDTO.getName().trim().toUpperCase())
					&& c.getCode().trim().toUpperCase().contains(cityDTO.getCode().trim().toUpperCase())
					&& c.getPostalCode().trim().toUpperCase().contains(cityDTO.getPostalCode().trim().toUpperCase())
					&& c.getCountry().getName().trim().toUpperCase().contains(cityDTO.getCountryName().trim().toUpperCase())) {
				System.out.println("NASAO");
				retVal.add(toCityDTO.convert(c));
			}
		}
		return new ResponseEntity<> (retVal, HttpStatus.OK);
	}
} 
