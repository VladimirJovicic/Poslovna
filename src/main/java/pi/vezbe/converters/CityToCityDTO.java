package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.DTO.CityDTO;
import pi.vezbe.model.City;


@Component
public class CityToCityDTO implements Converter<City, CityDTO> {

	@Override
	public CityDTO convert(City source) {
		
		if(source == null) {
			return null;
		}
		
		ModelMapper modelMapper = new ModelMapper();
		CityDTO cityDTO = modelMapper.map(source, CityDTO.class);
		return cityDTO;
	}
	
	public List<CityDTO> convert(List<City> source){
		
		List<CityDTO> citiesDTO = new ArrayList<CityDTO>();
		for (City city : source) {
			citiesDTO.add(convert(city));
		}
		
		return citiesDTO;
	}

}
