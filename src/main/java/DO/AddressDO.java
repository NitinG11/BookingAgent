package DO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="ADDRESS_SEQ", sequenceName="address_sequence")
public class AddressDO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ADDRESS_SEQ")
	private int id;
	private String addressLine1;
	private String addressLine2;
	
	public AddressDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressDO(int id, String addressLine1, String addressLine2) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
}
