package divisionwithdecimals.resultbuilder;

import java.util.Arrays;
import java.util.List;

import divisionwithdecimals.DivisionParameters;
import divisionwithdecimals.DivisionStep;

public class RemainderResultBuilder extends ResultBuilder {
	
	public RemainderResultBuilder(DivisionParameters divisionParameters, List<DivisionStep> divisionSteps) {
		this.divisionParameters = divisionParameters;
		this.divisionSteps = divisionSteps;
	}

	public String convertDivisionResultToString() {
		appendDivisionSteps(divisionSteps);
		appendLastLine(getIntegerLength(divisionParameters.getDividend()) + divisionSteps.size());
		return result.toString();
	}
	
	private void appendLastLine(int spaceShift) {
			result.append(createStringOfChars(spaceShift, ' ')).append("0");
	}
}
