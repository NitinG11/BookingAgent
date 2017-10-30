package services;

import model.HotelDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.IHotelRepository;

@Service
public class HotelService {

	@Autowired 
	IHotelRepository hotelRepo;
	public void addHotel(HotelDO hotel) {
		hotelRepo.save(hotel);
	}
}
