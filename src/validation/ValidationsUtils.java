package validation;

import dto.ValidationFormatNumberDTO;
import util.Response;

public interface ValidationsUtils {
	Response<ValidationFormatNumberDTO> validatedFromat(String numbersList);
	Response<Integer> validatedPositiveInteger(String number);
}
