package responses;

public enum StatusCodes {

	OK(200,"Success"),
	NOT_FOUND(404,"Not Found"),
	INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
	BAD_REQUEST(400,"Bad Request");
	
	private int code;
	private String description;
	private StatusCodes(int id, String name) {
		this.code = id;
		this.description = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
