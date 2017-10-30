package DO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="CONTACT_SEQ", sequenceName="contact_sequence")
public class ContactDO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CONTACT_SEQ")
	private int id;
	private String name;
	private long contact;
	private String email;

	@ManyToOne
	private HotelDO hotel;

	public ContactDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactDO(int id, String name, long contact, String email,
			HotelDO hotel) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.hotel = hotel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HotelDO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDO hotel) {
		this.hotel = hotel;
	}
	
	
	
}
