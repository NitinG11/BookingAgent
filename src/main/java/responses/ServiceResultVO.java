package responses;

public class ServiceResultVO<X> {

	private int statusCode;
	private String status;
	private X data;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public X getData() {
		return data;
	}
	public void setData(X data) {
		this.data = data;
	}
	
	
}
