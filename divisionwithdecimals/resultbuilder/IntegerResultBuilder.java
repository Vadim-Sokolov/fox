package divisionwithdecimals.resultbuilder;

import java.util.Arrays;
import java.util.List;

import divisionwithdecimals.DivisionParameters;
import divisionwithdecimals.DivisionStep;

public class IntegerResultBuilder extends ResultBuilder {
	
	public IntegerResultBuilder(DivisionParameters divisionParameters, List<DivisionStep> divisionSteps) {
		this.divisionParameters = divisionParameters;
		this.divisionSteps = divisionSteps;
	}

	public String convertDivisionResultToString() {
		int dividendLength = getIntegerLength(Math.abs(divisionParameters.getDividend()));
		appendFirstLine(divisionParameters, dividendLength);
		appendSecondLine(divisionParameters, dividendLength);
		appendThirdLine(divisionParameters, dividendLength);
		appendDivisionSteps(divisionSteps);
		appendLastLine(divisionParameters, dividendLength);
		return result.toString();
	}

	private void appendFirstLine(DivisionParameters divisionParameters, int dividendLength) {
		if (divisionParameters.getDividend() >= 0) {
			result.append("_");
		}
		if (dividendLength <= getIntegerLength(divisionParameters.getDivisor())) {
			result.append(divisionParameters.getDividend())
					.append(createStringOfChars(getIntegerLength(divisionParameters.getDivisor()) - dividendLength - 1, ' '))
					.append("|").append(divisionParameters.getDivisor()).append("\n");
		} else {
			result.append(divisionParameters.getDividend()).append("|").append(divisionParameters.getDivisor()).append("\n");
		}
	}

	private void appendSecondLine(DivisionParameters divisionParameters, int dividendLength) {
		if (divisionParameters.getDivisor() > 0) {
			result.append(" ");
		}
		result.append(divisionParameters.getDivisor())
				.append(createStringOfChars(dividendLength - getIntegerLength(Math.abs(divisionParameters.getDivisor())), ' '))
				.append("|");
		if (getIntegerLength(divisionParameters.getDivisor()) > getIntegerLength(divisionParameters.getQuotient())) {
			result.append(createStringOfChars(getIntegerLength(divisionParameters.getDivisor()), '-')).append("\n");
		} else {
			result.append(createStringOfChars(getIntegerLength(divisionParameters.getQuotient()), '-')).append("\n");
		}
	}

	private void appendThirdLine(DivisionParameters divisionParameters, int dividendLength) {
		result.append(" ").append(createStringOfChars(getIntegerLength(Math.abs(divisionParameters.getDivisor())), '-'))
				.append(createStringOfChars(dividendLength - getIntegerLength(Math.abs(divisionParameters.getDivisor())), ' '))
				.append("|").append(divisionParameters.getQuotient()).append("\n");
	}

	private void appendLastLine(DivisionParameters divisionParameters, int dividendLength) {
		if (divisionParameters.getRemainder() == 0) {
			result.append(createStringOfChars(dividendLength, ' ')).append("0");
		}
	}
}
