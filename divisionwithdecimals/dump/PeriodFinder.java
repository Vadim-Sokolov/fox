package divisionwithdecimals.dump;

import java.util.*;
import divisionwithdecimals.DivisionParameters;
import divisionwithdecimals.divider.Divider;

public class PeriodFinder extends Divider {

	public PeriodFinder(DivisionParameters divisionParameters) {
		this.divisionParameters = divisionParameters;
	}

	public String findPeriod() {
		int absoluteRemainder = Math.abs(divisionParameters.getRemainder());
		int absoluteDivisor = Math.abs(divisionParameters.getDivisor());
		String decimalNumber = getDecimalNumber(absoluteRemainder, absoluteDivisor);
		String repeatingDecimal = getRepeatingDecimal(decimalNumber);
		return repeatingDecimal;
	}

	private String getDecimalNumber(int absoluteRemainder, int absoluteDivisor) {
		int currentRemainder = absoluteRemainder;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			currentRemainder *= 10;
			if (currentRemainder >= absoluteDivisor) {
				result.append(currentRemainder / absoluteDivisor);
				currentRemainder = currentRemainder % absoluteDivisor;
			} else {
				result.append("0");
			}
		}
		return result.toString();
	}

	private String getRepeatingDecimal(String decimalNumber) {
		String blank = "";
		int n = decimalNumber.length();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				String currentDecimal = getLargestCommonPrefix(decimalNumber.substring(i, n), decimalNumber.substring(j, n));
				if (currentDecimal.length() > blank.length())
					blank = currentDecimal;
			}
		}
		return blank;
	}

	private String getLargestCommonPrefix(String s, String t) {
		int n = Math.min(s.length(), t.length());
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				return s.substring(0, i);
			}
		}
		return s.substring(0, n);
	}

	/*
	 * private Map<Integer, Integer> getDigitsOfDecimal(int absoluteRemainder, int
	 * absoluteDivisor) { Map<Integer, Integer> remainders = new TreeMap<>();
	 * Map<Integer, Integer> quotients = new TreeMap<>(); int currentRemainder =
	 * absoluteRemainder; int repeatingDecimal; for (int i = 0; i < 10; i++) { if
	 * (currentRemainder == 0) { break; } currentRemainder *= 10; if
	 * (currentRemainder >= absoluteDivisor) { int inputRemainder = currentRemainder
	 * % absoluteDivisor; if (remainders.containsValue(inputRemainder)) {
	 * remainders.put(i, inputRemainder); if
	 * (!quotients.containsValue(currentRemainder / absoluteDivisor)) {
	 * quotients.put(i, currentRemainder / absoluteDivisor); }
	 * getRepeatingDecimal(quotients, currentRemainder, absoluteDivisor); break; }
	 * remainders.put(i, inputRemainder); quotients.put(i, currentRemainder /
	 * absoluteDivisor); currentRemainder = inputRemainder; } else {
	 * quotients.put(i, 0); remainders.put(i, currentRemainder); } } return
	 * quotients; }
	 */

	private int getRepeatingDecimal(Map<Integer, Integer> quotients, int currentRemainder, int absoluteDivisor) {

	}

	private String getPeriod(Map<Integer, Integer> digits) {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, Integer> e : digits.entrySet()) {
			result.append(e.getValue());
		}
		return result.toString();
	}

	public static void main(String[] args) {
		PeriodFinder pf = new PeriodFinder(new DivisionParameters(25, 39));
		System.out.println(pf.divisionParameters.getRemainder() + " " + pf.divisionParameters.getDivisor());
		System.out.println(pf.divisionParameters.getRemainder() * 10 % pf.divisionParameters.getDivisor());
		System.out.println("==========");
		System.out.println(pf.findPeriod());
	}

	/*
	 * Multiply the remainder by 10. Append remainder / divisor to result. Remainder
	 * = remainder % divisor.
	 * 
	 * At any moment, if remainder becomes 0, we are done.
	 * 
	 * So the idea is to store seen remainders in a map. Whenever a remainder
	 * repeats, we return the sequence before the next occurrence.
	 */
}
