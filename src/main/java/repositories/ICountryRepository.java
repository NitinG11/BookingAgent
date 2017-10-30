package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DO.CountryDO;
import DO.HotelDO;


@Repository
public interface ICountryRepository extends JpaRepository<CountryDO, Long> {

	CountryDO findByCountryName(String name);
	CountryDO findById(long id);
}
