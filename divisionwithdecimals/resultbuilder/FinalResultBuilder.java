package divisionwithdecimals.resultbuilder;

public class FinalResultBuilder {
	
	private String integerDivisionResult;
	private String remainderDivisionResult;
	
	public FinalResultBuilder(String integerDivisionResult, String remainderDivisionResult) {
		this.integerDivisionResult = integerDivisionResult;
		this.remainderDivisionResult = remainderDivisionResult;
	}
		
	public String getDivisionResult() {
		return new String(integerDivisionResult + remainderDivisionResult);
	}
}
