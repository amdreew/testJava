package app.dto;

import java.util.List;

public class ValidationFormatNumberDTO {
	private List<String> allNumber;
	private List<String> errorNumber;
	
	public ValidationFormatNumberDTO() {
	}

	public ValidationFormatNumberDTO(List<String> allNumber, List<String> errorNumber) {
		this.allNumber = allNumber;
		this.errorNumber = errorNumber;
	}

	public List<String> getAllNumber() {
		return allNumber;
	}

	public void setAllNumber(List<String> allNumber) {
		this.allNumber = allNumber;
	}

	public List<String> getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(List<String> errorNumber) {
		this.errorNumber = errorNumber;
	}
	
	
	
	
	
	
}
