package util.validation;

import app.dto.ValidationFormatNumberDTO;
import util.Response;

public interface ValidationsUtils {
	Response<ValidationFormatNumberDTO> validatedFromat(String numbersList);
	Response<Integer> validatedPositiveInteger(String number);
}
