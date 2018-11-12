package divisionwithdecimals;

import divisionwithdecimals.divider.IntegerDivider;
import divisionwithdecimals.divider.RemainderDivider;
import divisionwithdecimals.resultbuilder.IntegerResultBuilder;
import divisionwithdecimals.resultbuilder.RemainderResultBuilder;

public class DividerRunner {

	public static void main(String[] args) {
		DivisionParameters divisionParameters = new DivisionParameters(78459, 4);
		//Divider1 d1 = new Divider1(divisionParameters);
		IntegerDivider divider = new IntegerDivider(divisionParameters);
		divider.performIntegerDivision();
		IntegerResultBuilder integerResultBuilder = new IntegerResultBuilder(divider.getDivisionParameters(), divider.getDivisionSteps());
		String result = integerResultBuilder.convertDivisionResultToString();
		RemainderDivider remainderDivider = new RemainderDivider(divider.getDivisionParameters());
		remainderDivider.performRemainderDivision();
		RemainderResultBuilder remainderResultBuilder = new RemainderResultBuilder(remainderDivider.getDivisionParameters(), remainderDivider.getDivisionSteps());
		result += remainderResultBuilder.convertDivisionResultToString();
		System.out.println(result);
	}
}
