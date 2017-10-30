package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DO.CityDO;


@Repository
public interface ICityRepository extends JpaRepository<CityDO, Long> {

	
}
