package pi.vezbe.service;

import java.util.List;

import pi.vezbe.model.*;

public interface CountryService {

	/**
	 * Returns a country with specified ID.
	 * @param id ID of the country
	 * @return Country, if country with such ID
	 * exists, {@code null} if country is not found.
	 */
	Country findOne(Long id);
	
	/**
	 *  
	 * @return List of all existing countries.
	 */
	List<Country> findAll();
	
	/**
	 * Persists a country. If country's id is null,
	 * a new id will be assigned automatically.
	 * @param country
	 * @return country state after persisting. 
	 */
	Country save(Country country);
	
	/**
	 * Persist a list of countries
	 * @param countries
	 * @return
	 */
	List<Country> save(List<Country> countries);
	
	/**
	 * Deletes a country having specified ID.
	 * @param id ID of the country to be removed. 
	 * @return Removed country if removal is successful. 
	 * If the country was not found, an {@link IllegalArgumentException}
	 * is thrown.
	 */
	Country delete(Long id);
	
	/**
	 * Remove a list of countries.
	 * @param ids A {@link List} of country IDs (each ID is of type {@link Long})
	 */
	void delete(List<Long> ids);
	
	Country findByName(String name);
}
