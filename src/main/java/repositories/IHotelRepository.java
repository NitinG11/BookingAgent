package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.HotelDO;


@Repository
public interface IHotelRepository extends JpaRepository<HotelDO, Long> {

	List<HotelDO> findByCityCityNameAndActive(String cityName,boolean active);
	
}
