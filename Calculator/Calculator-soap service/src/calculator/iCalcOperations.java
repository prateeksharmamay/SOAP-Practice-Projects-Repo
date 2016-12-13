package calculator;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface iCalcOperations {
	
	@WebMethod
	float add(float num1, float num2);
	
	@WebMethod
	float substract(float num1, float num2);
	
	@WebMethod
	float multiply(float num1, float num2);
	
	@WebMethod
	float divide(float num1, float num2);
}
