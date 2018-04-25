package pi.vezbe;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pi.vezbe.model.City;
import pi.vezbe.model.Country;
import pi.vezbe.service.CityService;
import pi.vezbe.service.CountryService;

@Component
public class TestData {
	
	@Autowired
	private CountryService	countryService;
	
	@Autowired
	private CityService cityService;
	
	@PostConstruct
	private void init(){
		
		Country country1 = new Country("Serbia", "SRB");
		City city1 = new City("Sombor" , "25000", country1,"SO");
		City city2 = new City("Novi Sad" , "21000", country1,"NS");
		country1.getCities().add(city1);
		country1.getCities().add(city2);
		countryService.save(country1);
		cityService.save(city1);
		cityService.save(city2);
		
		Country country2 = new Country("Belgium", "BEL");
		countryService.save(country2);
		
		Country country3 = new Country("Portugal", "POR");
		countryService.save(country3);

		Country country4 = new Country("Estonia", "EST");
		countryService.save(country4);
		
		Country country5 = new Country("Lithuania", "LIT");
		countryService.save(country5);
		
		
		
		
	}
}
