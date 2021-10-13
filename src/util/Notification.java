package util;

public class Notification {
	private String description;
    private String responseTime;
    private TypeResponse code;

	public Notification() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public TypeResponse getCode() {
		return code;
	}

	public void setCode(TypeResponse code) {
		this.code = code;
	}
    
}
