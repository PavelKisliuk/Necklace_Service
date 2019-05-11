package xxx.necklaceservice.validator;

import xxx.necklaceservice.exception.CustomException;

public interface IChecker {
	String UNSIGNED_DOUBLE_PATTERN = "\\d+(\\.\\d+)?";

	boolean isValid(String[] elementsString) throws CustomException;

	default boolean isValidUnsignedDouble(String unsignedDouble) {
		return unsignedDouble.matches(UNSIGNED_DOUBLE_PATTERN);
	}
}
