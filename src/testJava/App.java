package testJava;
import java.util.List;

import javax.swing.JOptionPane;

import dto.ValidationFormatNumberDTO;
import util.Response;
import util.TypeResponse;
import validation.ValidationsUtils;

public class App {
	
	private ValidationsUtils validationsUtils;
	
	
	
	public App(ValidationsUtils validationsUtils) {
		this.validationsUtils = validationsUtils;
	}


	public void initApp() {
		Response<ValidationFormatNumberDTO> validationFormatNumber = this.validationsUtils.validatedFromat(
				JOptionPane.showInputDialog("Porfavor ingrese el listado de numeros reales separados por guiones..."));
		Response<Integer> validatedPositiveInteger = this.validationsUtils.validatedPositiveInteger(
				JOptionPane.showInputDialog("Porfavor ingrese un numero entero para operar"));		
		if(validationFormatNumber.getNotification().getCode() == TypeResponse.SUCCESS 
				&& validatedPositiveInteger.getNotification().getCode() == TypeResponse.SUCCESS ) {
			processData(validationFormatNumber.getData().getAllNumber(), validatedPositiveInteger.getData());
		} else {
			processValidatedErrorsNumberFormat(validationFormatNumber);
			processValidatedErrorPositiveInteger(validatedPositiveInteger);
		}
	}
	
	private void processData(List<String> numberList, Integer numberForProcess) {
		if(numberForProcess > numberList.size()) {
			viewErrorMessage("el numero para operar N no puede ser mayor a la cantidad de elementos del arreglo");
		} else {
			Float acumulado = (float) 0;
			System.out.println("tamaño de la lista "+ numberList.size()+ " numero de elemento a tomar "+ numberForProcess);
			for(int i = numberList.size(); i > (numberList.size() - numberForProcess); i-- ) {
				Float value = Float.parseFloat(numberList.get(i -1));
				acumulado += value;
			}
			JOptionPane.showMessageDialog(null, "el acumulado fue de "+ acumulado + " y su raiz es: "+ Math.sqrt(acumulado),
				      "Hey!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void processValidatedErrorsNumberFormat(Response<ValidationFormatNumberDTO> validation) {
		if(validation.getNotification().getCode() == TypeResponse.ERROR) {
			String numberFailedFormat = validation.getData().getErrorNumber()
					.stream()
					.reduce("", (subtotal, element) -> subtotal + "  " +element);
			viewErrorMessage("los numeros (" + numberFailedFormat + ") no cumplen con el formato especificado");
		}
	}
	
	private void processValidatedErrorPositiveInteger(Response<Integer> validation) {
		if(validation.getNotification().getCode() == TypeResponse.ERROR) {
			viewErrorMessage(validation.getNotification().getDescription());
		}
	}
	
	private void viewErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message,
			      "Hey!", JOptionPane.ERROR_MESSAGE);
	}

}
