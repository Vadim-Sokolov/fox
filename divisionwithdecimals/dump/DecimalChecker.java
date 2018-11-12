package divisionwithdecimals.dump;

import java.util.HashSet;
import java.util.Set;

public class DecimalChecker {

	public boolean isTerminatingDecimal(int divisor) {
		return checkPrimeFactors(reduceToPrimeFactors(divisor));
	}
	
	private boolean checkPrimeFactors(Set<Integer> primeFactors) {
		boolean result = true;
		for (int i : primeFactors) {
			if (i != 2 && i != 5) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	private Set<Integer> reduceToPrimeFactors(int number) {
        int n = number;
        Set<Integer> primeFactors = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
            	primeFactors.add(i);
                n /= i;
            }
        }
        return primeFactors;
    }
}
