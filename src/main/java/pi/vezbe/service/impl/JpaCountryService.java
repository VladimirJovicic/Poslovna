package pi.vezbe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pi.vezbe.model.Country;
import pi.vezbe.repository.CountryRepository;
import pi.vezbe.service.CountryService;

@Transactional
@Service
public class JpaCountryService implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country findOne(Long id) {
		return countryRepository.findOne(id);
	}
	
	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public List<Country> save(List<Country> countries) {
		return countryRepository.save(countries);
	}

	@Override
	public Country delete(Long id) {
		Country country = countryRepository.findOne(id);
		if(country == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant country");
		}
		countryRepository.delete(country);
		return country;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

	@Override
	public Country findByName(String name) {
		return countryRepository.findByName(name);
	}

}
