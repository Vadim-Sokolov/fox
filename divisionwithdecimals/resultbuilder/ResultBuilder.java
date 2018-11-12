package divisionwithdecimals.resultbuilder;

import java.util.Arrays;
import java.util.List;

import divisionwithdecimals.DivisionParameters;
import divisionwithdecimals.DivisionStep;

public class ResultBuilder {

	protected StringBuilder result = new StringBuilder();
	protected final int DIVIDEND_SHIFT_SPACES = 2;
	protected final int SUBTRACTION_SHIFT_SPACES = 1;
	protected DivisionParameters divisionParameters;
	protected List<DivisionStep> divisionSteps;
	
	protected int getIntegerLength(int input) {
		return Integer.toString(input).length();
	}
	
	protected void appendDivisionSteps(List<DivisionStep> divisionSteps) {
		int index = 0;
		if (getIntegerLength(divisionSteps.get(index).getIntegerToSubtract()) == 1) {
			index++;
		}
		for (int i = index; i < divisionSteps.size(); i++) {
			String dividendSpaces = createStringOfChars(divisionSteps.get(i).getSpaceShift() - DIVIDEND_SHIFT_SPACES, ' ');
			String integerToSubtractSpaces = createStringOfChars(divisionSteps.get(i).getSpaceShift() - SUBTRACTION_SHIFT_SPACES, ' ');
			appendLineToResult(result, dividendSpaces, integerToSubtractSpaces, divisionSteps, i);
		}
	}
	
	protected String createStringOfChars(int length, char input) {
		String result = "";
		if (length > 0) {
			char[] array = new char[length];
			Arrays.fill(array, input);
			result = new String(array);
		}
		return result;
	}

	private void appendLineToResult(StringBuilder result, String dividendSpaces, String integerToSubtractSpaces,
			List<DivisionStep> divisionSteps, int index) {
		result.append(dividendSpaces).append("_").append(divisionSteps.get(index).getDividend()).append("\n")
				.append(integerToSubtractSpaces).append(divisionSteps.get(index).getIntegerToSubtract()).append("\n").append(integerToSubtractSpaces)
				.append(createStringOfChars(getIntegerLength(divisionSteps.get(index).getIntegerToSubtract()), '-'))
				.append("\n");
	}
	
	public StringBuilder getResult() {
		return result;
	}

	public void setResult(StringBuilder result) {
		this.result = result;
	}

	public DivisionParameters getDivisionParameters() {
		return divisionParameters;
	}

	public void setDivisionParameters(DivisionParameters divisionParameters) {
		this.divisionParameters = divisionParameters;
	}
}
