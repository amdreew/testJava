package util;

import java.time.LocalDateTime;

public class Notification {
	private String description;
    private String responseTime;
    private TypeResponse code;

    public Notification(String decription, TypeResponse code) {
        this.description = decription;
        this.code = code;
        this.responseTime = LocalDateTime.now().toString();
    }

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
