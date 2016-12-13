package calculator;

public class CalcOperationsImpl implements iCalcOperations{

	@Override
	public float add(float num1, float num2) {
		return num1+num2;
	}

	@Override
	public float substract(float num1, float num2) {
		return num1-num2;
	}

	@Override
	public float multiply(float num1, float num2) {
		return num1*num2;
	}

	@Override
	public float divide(float num1, float num2) {
		return num1/num2;
	}

}
