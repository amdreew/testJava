package app.process;

import app.dto.ValidationFormatNumberDTO;
import util.Response;

public interface ProcessFaildValidation {
    void processValidatedErrorsNumberFormat(Response<ValidationFormatNumberDTO> validation);
    void processValidatedErrorPositiveInteger(Response<Integer> validation);
}
