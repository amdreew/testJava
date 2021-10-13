package util.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import app.dto.ValidationFormatNumberDTO;
import util.exeption.ParamsInvalidException;
import util.Notification;
import util.Response;
import util.TypeResponse;

public class ValidationsUtilsImpl implements ValidationsUtils {
	private Pattern PAT_FORMT_NUMBER = Pattern.compile("^[0-9]+([.][0-9]+)?$");
	

	@Override
	public Response<ValidationFormatNumberDTO> validatedFromat(String numbersListStr) {
		if(numbersListStr == null || numbersListStr.trim().isEmpty()) {
			throw new ParamsInvalidException("el listado de numeros no puede ser nulo o vacio"); 
		}
		List<String> numbersList = Arrays.asList(numbersListStr.split("-"))
				.stream()
                .map(x -> x.trim())
                .collect(Collectors.toList());
		List<String> numbersFormaterror = new ArrayList<>();				
		numbersList.forEach((item) -> {
			Matcher mat = PAT_FORMT_NUMBER.matcher(item);
			if (!mat.matches()) {
				numbersFormaterror.add(item);
			}
		});
		Response<ValidationFormatNumberDTO> response = new Response<ValidationFormatNumberDTO>();
		ValidationFormatNumberDTO validationFormatNumberDTO = new ValidationFormatNumberDTO();
		validationFormatNumberDTO.setAllNumber(numbersList);
		validationFormatNumberDTO.setErrorNumber(numbersFormaterror);
		response.setData(validationFormatNumberDTO);
		Notification notification = new Notification();
		if(numbersFormaterror.size() == 0) {
			notification.setCode(TypeResponse.SUCCESS);
			notification.setDescription("Validacion de formatos existosa!");
		} else {
			notification.setCode(TypeResponse.ERROR);
			notification.setDescription("La validacion de formatos no ha sido existosa!");
		}
		response.setNotification(notification);		
		return response;
	}

	@Override
	public Response<Integer> validatedPositiveInteger(String number) {
		Response<Integer> response = new Response<Integer>();
		Notification notification = new Notification();
		try {
			Integer validateNumber = Integer.parseInt(number);
			notification.setCode(validateNumber > 0? TypeResponse.SUCCESS : TypeResponse.ERROR);
			notification.setDescription(notification.getCode() == TypeResponse.SUCCESS? "Validacion de enteros positivos existosa!" : 
				"La validacion de enteros positivos para: ( "+ validateNumber +" ), no fue existosa, es entero, pero no positivo!");
			response.setData(validateNumber);
			response.setNotification(notification);
			return response;
		} catch (NumberFormatException nfe){
			notification.setCode(TypeResponse.ERROR);
			notification.setDescription("La validacion de enteros positivos no fue existosa, No es un entero!");
			response.setData(null);
			response.setNotification(notification);
			return response;
		}
	}

}
