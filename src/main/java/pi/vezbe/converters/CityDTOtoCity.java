package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.DTO.CityDTO;
import pi.vezbe.model.City;
import pi.vezbe.model.Country;
import pi.vezbe.service.CountryService;

@Component
public class CityDTOtoCity implements Converter<CityDTO, City> {

	@Autowired
	private CountryService countryService;
	
	@Override
	public City convert(CityDTO source) {
		
		if(source == null) {
			return null;
		}
		
		City city = new City();
		
		city.setId(source.getId());
		city.setName(source.getName());
		city.setCode(source.getCode());
		city.setPostalCode(source.getPostalCode());
		
		if(source.getCountryId() != null) {
			Country country = countryService.findOne(source.getCountryId());
			city.setCountry(country);
			country.getCities().add(city);
		}
		
		return city;
	}
	
	
	public List<City> convert(List<CityDTO> source){
		
		List<City> cities = new ArrayList<City>();
		for (CityDTO cityDTO : source) {
			cities.add(convert(cityDTO));
		}
		
		return cities;
	}
}
