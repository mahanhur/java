package cal;

public class Cal {
	public static double div(int a, int b) throws Exception{
		double result = 0.0;
		try {
			result = a / b;
			return result;			
		} catch(ArithmeticException e) {
			throw e;
		}

	}
	
	public static double div(double a, double b) throws InfinityException {
		double result = 0.0;
		if(b == 0.0) {
			throw new InfinityException("A0001");
		} else {
		result = a / b;
		return result;
		}
}
}
