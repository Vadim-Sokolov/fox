package divisionwithdecimals;

import java.util.ArrayList;
import java.util.List;

public class DivisionParameters {

	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;
	private int currentIndex;
	private String result;

	public DivisionParameters(int dividend, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		this.dividend = dividend;
		this.divisor = divisor;
		this.quotient = dividend / divisor;
		this.remainder = dividend % divisor;
	}

	public int getDividend() {
		return dividend;
	}

	public void setDividend(int dividend) {
		this.dividend = dividend;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}

	public int getQuotient() {
		return quotient;
	}

	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
