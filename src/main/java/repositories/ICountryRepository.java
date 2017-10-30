package repositories;

import model.CountryDO;
import model.HotelDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ICountryRepository extends JpaRepository<CountryDO, Long> {

	CountryDO findByCountryName(String name);
	CountryDO findById(long id);
}
