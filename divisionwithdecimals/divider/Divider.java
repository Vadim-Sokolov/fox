package divisionwithdecimals.divider;

import java.util.ArrayList;
import java.util.List;

import divisionwithdecimals.DivisionParameters;
import divisionwithdecimals.DivisionStep;

public class Divider {
	
	protected List<DivisionStep> divisionSteps = new ArrayList<>();
	protected DivisionParameters divisionParameters;
	
	protected void createStep(int currentDividendNumber, int divisor, int spaceShift) {
		int currentQuotient = currentDividendNumber / divisor;
		int integerToSubtract = divisor * currentQuotient;
		divisionSteps.add(new DivisionStep(currentDividendNumber, integerToSubtract, spaceShift));
	}
	
	public List<DivisionStep> getDivisionSteps() {
		return divisionSteps;
	}
	
	public void setDivisionSteps(List<DivisionStep> divisionSteps) {
		this.divisionSteps = divisionSteps;
	}

	public DivisionParameters getDivisionParameters() {
		return divisionParameters;
	}
}
