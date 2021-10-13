package app;

import app.dto.ValidationFormatNumberDTO;
import app.process.ProcessData;
import app.process.ProcessDataImp;
import app.process.ProcessFaildValidation;
import app.process.ProcessFaildValidationImpl;
import util.Response;
import util.TypeResponse;
import util.message.Message;
import util.validation.ValidationsUtils;
import util.validation.ValidationsUtilsImpl;

public class App {

	private final ValidationsUtils validationsUtils;
	private final ProcessData processData;
	private final ProcessFaildValidation processFaildValidation;
	
	public App() {
		this.validationsUtils = new ValidationsUtilsImpl();
		this.processData = new ProcessDataImp();
		this.processFaildValidation = new ProcessFaildValidationImpl();
	}

	public void initApp() {
		Response<ValidationFormatNumberDTO> validationFormatNumber = this.validationsUtils.validatedFromat(
				Message.inputMessage("Porfavor ingrese el listado de numeros reales separados por guiones..."));
		Response<Integer> validatedPositiveInteger = this.validationsUtils.validatedPositiveInteger(
				Message.inputMessage("Porfavor ingrese un numero entero para operar"));
		if(validationFormatNumber.getNotification().getCode() == TypeResponse.SUCCESS 
				&& validatedPositiveInteger.getNotification().getCode() == TypeResponse.SUCCESS ) {
			this.processData.processData(validationFormatNumber.getData().getAllNumber(), validatedPositiveInteger.getData());
		} else {
			this.processFaildValidation.processValidatedErrorsNumberFormat(validationFormatNumber);
			this.processFaildValidation.processValidatedErrorPositiveInteger(validatedPositiveInteger);
		}
	}
	

	


}
