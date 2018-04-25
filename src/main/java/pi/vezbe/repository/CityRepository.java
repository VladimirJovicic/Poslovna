package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pi.vezbe.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
	List<City> findByCountryCode(String code);
}
