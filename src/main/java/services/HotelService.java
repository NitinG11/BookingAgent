package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.HotelDO;
import repositories.IHotelRepository;

@Service
public class HotelService {

	@Autowired 
	IHotelRepository hotelRepo;
	public void addHotel(HotelDO hotel) {
		hotelRepo.save(hotel);
	}
	
	public List<HotelDO> findByCity(String cityName,boolean active) {
		return hotelRepo.findByCityCityNameAndActive(cityName,active);
	}
}
