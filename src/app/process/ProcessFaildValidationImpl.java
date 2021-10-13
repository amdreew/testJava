package app.process;

import app.dto.ValidationFormatNumberDTO;
import util.Response;
import util.TypeResponse;
import util.message.Message;

public class ProcessFaildValidationImpl implements ProcessFaildValidation {
    @Override
    public void processValidatedErrorsNumberFormat(Response<ValidationFormatNumberDTO> validation) {
        if(validation.getNotification().getCode() == TypeResponse.ERROR) {
            String numberFailedFormat = validation.getData().getErrorNumber()
                    .stream()
                    .reduce("", (subtotal, element) -> subtotal + "  " +element);
            Message.showMessageDialog("los numeros (" + numberFailedFormat + ") no cumplen con el formato especificado");
        }
    }

    @Override
    public void processValidatedErrorPositiveInteger(Response<Integer> validation) {
        if(validation.getNotification().getCode() == TypeResponse.ERROR) {
            Message.showMessageDialog(validation.getNotification().getDescription());
        }
    }
}
