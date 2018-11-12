package divisionwithdecimals.divider;

import java.util.ArrayList;
import java.util.List;

import divisionwithdecimals.DivisionParameters;

public class IntegerDivider extends Divider {
		
	public IntegerDivider(DivisionParameters divisionParameters) {
		this.divisionParameters = divisionParameters;
	}

	public void performIntegerDivision() {
		int absoluteDividend = Math.abs(divisionParameters.getDividend());
		int absoluteDivisor = Math.abs(divisionParameters.getDivisor());
		int[] digitsOfDividend = convertIntegerToDigits(absoluteDividend);
		divide(absoluteDivisor, digitsOfDividend);
	}

	private int[] convertIntegerToDigits(int input) {
		String integerToString = Integer.toString(input);
		int[] digits = new int[integerToString.length()];
		for (int i = 0; i < integerToString.length(); i++) {
			digits[i] = Character.getNumericValue(integerToString.charAt(i));
		}
		return digits;
	}

	private void divide(int divisor, int[] digitsOfDividend) {
		int currentDividendNumber = digitsOfDividend[0];
		int index = 0;
		while (index < digitsOfDividend.length) {
			if (currentDividendNumber < divisor) {
				if (index == 0) {
					index++;
				}
				currentDividendNumber = getNextDividend(currentDividendNumber, digitsOfDividend, index, divisor);
				index = divisionParameters.getCurrentIndex();
			} else {
				index++;
			}
			createStep(currentDividendNumber, divisor, divisionParameters.getCurrentIndex());
			currentDividendNumber = currentDividendNumber % divisor;
		}
		setDivisionSteps(divisionSteps);
	}

	private int getNextDividend(int currentDividendNumber, int[] digits, int index, int divisor) {
		while (currentDividendNumber < divisor) {
			if (index < digits.length) {
				currentDividendNumber = combineTwoIntegers(currentDividendNumber, digits[index++]);
			} else {
				break;
			}
		}
		divisionParameters.setCurrentIndex(index);
		return currentDividendNumber;
	}

	private int combineTwoIntegers(int first, int second) {
		return Integer.parseInt(Integer.toString(first) + Integer.toString(second));
	}
}
