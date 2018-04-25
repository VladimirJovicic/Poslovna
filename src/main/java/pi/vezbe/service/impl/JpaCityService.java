package pi.vezbe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pi.vezbe.model.City;
import pi.vezbe.repository.CityRepository;
import pi.vezbe.service.CityService;

@Transactional
@Service
public class JpaCityService implements CityService{

	@Autowired
	CityRepository cityrepository;
	
	@Override
	public City findOne(Long id) {
		return cityrepository.findOne(id);
	}

	@Override
	public List<City> findAll() {
		return cityrepository.findAll();
	}

	@Override
	public City save(City city) {
		return cityrepository.save(city);
	}

	@Override
	public List<City> save(List<City> cities) {
		return cityrepository.save(cities);
	}

	@Override
	public City delete(Long id) {
		City city = cityrepository.findOne(id);
		if(city == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant city");
		}
		cityrepository.delete(city);
		return city;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
		
	}

	@Override
	public List<City> findByCountryCode(String code) {
		return cityrepository.findByCountryCode(code);
	}

}
