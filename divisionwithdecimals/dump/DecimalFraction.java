package divisionwithdecimals.dump;

import java.util.*;

public class DecimalFraction {

	private int wholePart;
	private int repeatingAt;
	private List<Integer> fractionDigits;
	boolean negativeResult;

	DecimalFraction(int dividend, int divisor) {
		int absoluteDividend = Math.abs(dividend);
		int absoluteDivisor = Math.abs(divisor);
		negativeResult = (double) dividend / divisor < 0;
		wholePart = absoluteDividend / absoluteDivisor;
		absoluteDividend = (absoluteDividend % absoluteDivisor) * 10;
		fractionDigits = new ArrayList<Integer>();
		repeatingAt = -1;

		List<Integer> remainders = new ArrayList<Integer>();
		while (absoluteDividend > 0 && repeatingAt == -1) {
			remainders.add(absoluteDividend);
			int whole = absoluteDividend / absoluteDivisor;
			absoluteDividend = (absoluteDividend % absoluteDivisor) * 10;
			fractionDigits.add(whole);
			repeatingAt = remainders.indexOf(absoluteDividend);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		if (negativeResult) {
			result.append("-");
		}
		result.append(wholePart + ".");
		for (int i = 0; i < fractionDigits.size(); i++) {
			if (i == repeatingAt) {
				result.append("(");
			}
			result.append(fractionDigits.get(i));
		}
		if (repeatingAt >= 0) {
			result.append(")");
		}
		return result.toString();
	}

	public static void main(String[] args) {
		DecimalFraction dfrac = new DecimalFraction(7, -12);
		System.out.println("Result: " + dfrac.toString());
		System.out.println(dfrac.negativeResult);
		System.out.println();
	}
}
