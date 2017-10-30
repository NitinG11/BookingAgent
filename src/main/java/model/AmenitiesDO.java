package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AMENITIES")
@SequenceGenerator(name="AMENITIES_SEQ", sequenceName="amenities_sequence")
public class AmenitiesDO {

	@Id
	@Column(name= "ID", nullable = false, unique= true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="AMENITIES_SEQ")
	private int id;
	
	@Column(name= "DESCRIPTION",length=100)
	private String description;
	
	@ManyToOne
	@JoinColumn(name= "HOTEL_ID", nullable = false)
	private HotelDO hotel;

	public AmenitiesDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AmenitiesDO(int id, String description, HotelDO hotel) {
		super();
		this.id = id;
		this.description = description;
		this.hotel = hotel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HotelDO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDO hotel) {
		this.hotel = hotel;
	}
	
	
}
