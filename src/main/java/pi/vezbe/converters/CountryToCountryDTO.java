package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.DTO.CountryDTO;
import pi.vezbe.model.Country;

@Component
public class CountryToCountryDTO  implements Converter<Country, CountryDTO> {

	@Override
	public CountryDTO convert(Country source) {
		
		if(source == null) {
			return null;
		}
		
		ModelMapper modelMapper = new ModelMapper();
		CountryDTO countryDTO = modelMapper.map(source, CountryDTO.class);
		return countryDTO;
	}
	
	public List<CountryDTO> convert(List<Country> source){
		
		List<CountryDTO> countriesDTO = new ArrayList<CountryDTO>();
		for (Country country : source) {
			countriesDTO.add(convert(country));
		}
		
		return countriesDTO;
	}
}
