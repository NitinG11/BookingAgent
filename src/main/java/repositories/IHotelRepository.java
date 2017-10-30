package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DO.HotelDO;


@Repository
public interface IHotelRepository extends JpaRepository<HotelDO, Long> {

	
}
