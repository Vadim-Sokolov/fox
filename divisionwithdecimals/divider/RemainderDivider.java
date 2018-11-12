package divisionwithdecimals.divider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import divisionwithdecimals.DivisionParameters;

public class RemainderDivider extends Divider {
		
	public RemainderDivider(DivisionParameters divisionParameters) {
		this.divisionParameters = divisionParameters;
	}

	public void performRemainderDivision() {
		int currentRemainder = divisionParameters.getRemainder() * 10;
		for (int i = 1; i < 10; i++) {
			if (currentRemainder >= divisionParameters.getDivisor()) {
				createStep(currentRemainder, divisionParameters.getDivisor(), i + getIntegerLength(divisionParameters.getDividend()));
				currentRemainder = currentRemainder % divisionParameters.getDivisor();
				if (currentRemainder == 0) {
					break;
				}
				currentRemainder *= 10;
			}
		}
		setDivisionSteps(divisionSteps);
	}
	
	private int getIntegerLength(int input) {
		return Integer.toString(input).length();
	}
	
 /*   Multiply the remainder by 10.
    Append remainder / denominator to result.
    Remainder = remainder % denominator.

At any moment, if remainder becomes 0, we are done.

So the idea is to store seen remainders in a map. 
Whenever a remainder repeats, we return the sequence before the next occurrence.
	*/
}
