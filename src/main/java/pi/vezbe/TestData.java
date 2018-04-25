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
		City city1Serbia = new City("Sombor" , "25000", country1,"SO");
		City city2Serbia = new City("Novi Sad" , "21000", country1,"NS");
		City city3Serbia = new City("Subotica" , "24000", country1,"SU");
		country1.getCities().add(city1Serbia);
		country1.getCities().add(city2Serbia);
		country1.getCities().add(city3Serbia);
		countryService.save(country1);
		cityService.save(city1Serbia);
		cityService.save(city2Serbia);
		cityService.save(city3Serbia);
		

		Country country2 = new Country("Belgium", "BEL");
		City city1Belgium = new City("Brisel" , "11200", country2,"BR");
		City city2Belgium = new City("Mons" , "70000", country2,"MO");
		City city3Belgium = new City("Mehelen" , "28001", country2,"ME");
		country2.getCities().add(city1Belgium);
		country2.getCities().add(city2Belgium);
		country2.getCities().add(city3Belgium);
		countryService.save(country2);
		cityService.save(city1Belgium);
		cityService.save(city2Belgium);
		cityService.save(city3Belgium);
		
		
		
		Country country3 = new Country("Portugal", "POR");
		City city1Portugal = new City("Lisabon" , "10010", country3,"LI");
		City city2Portugal = new City("Braga" , "47000", country3,"BR");
		City city3Portugal = new City("Evora" , "48001", country3,"EV");
		country3.getCities().add(city1Portugal);
		country3.getCities().add(city2Portugal);
		country3.getCities().add(city3Portugal);
		countryService.save(country3);
		cityService.save(city1Portugal);
		cityService.save(city2Portugal);
		cityService.save(city3Portugal);
		
		

		Country country4 = new Country("Estonia", "EST");
		City city1Estonia = new City("Talin" , "10010", country4,"TA");
		City city2Estonia = new City("Tartu" , "50096", country4,"TT");
		City city3Estonia = new City("Parnu" , "80010", country4,"PR");
		country4.getCities().add(city1Estonia);
		country4.getCities().add(city2Estonia);
		country4.getCities().add(city3Estonia);
		countryService.save(country4);
		cityService.save(city1Estonia);
		cityService.save(city2Estonia);
		cityService.save(city3Estonia);
		
		
		Country country5 = new Country("Lithuania", "LIT");
		City city1Lithuania = new City("Vilnius" , "01100", country5,"VI");
		City city2Lithuania = new City("Kaunas" , "44100", country5,"KA");
		City city3Lithuania = new City("Klajpeda" , "91100", country5,"KL");
		country5.getCities().add(city1Lithuania);
		country5.getCities().add(city2Lithuania);
		country5.getCities().add(city3Lithuania);
		countryService.save(country5);
		cityService.save(city1Lithuania);
		cityService.save(city2Lithuania);
		cityService.save(city3Lithuania);
		
		
		
	}
}
