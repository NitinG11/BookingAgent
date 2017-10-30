package repositories;

import java.util.List;

import model.CityDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICityRepository extends JpaRepository<CityDO, Long> {

	public CityDO findByCityName(String name);
	
	public List<CityDO> findByCountryCountryName(String name);
}
