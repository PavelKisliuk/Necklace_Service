/*
 * By Pavel Kisliuk, 11.05.2019
 * This is class for education and nothing rights don't reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package xxx.necklaceservice.validator;

import xxx.necklaceservice.exception.CustomException;

/**
 * The {@code IChecker} interface provide method for validation data from
 * array of {@code String}
 *
 * @author Kisliuk Pavel Sergeevich
 * @see StoneChecker
 * @see GemstoneChecker
 * @see CanvasChecker
 * @see NecklaceElementChecker
 * @see NecklaceChecker
 * @since 12.0
 */
public interface IChecker {
	/**
	 * String represent's pattern for regular expression for validation
	 * value as double
	 */
	String UNSIGNED_DOUBLE_PATTERN = "\\d+(\\.\\d+)?";

	/**
	 * Return {@code true} if all element's of {@param elementsString} are valid,
	 * else return {@code false}
	 *
	 * @param elementsString is array of {@code String} for validation
	 * @return {@code true} if all element's of {@param elementsString} are valid
	 * @throws CustomException if {@param elementsString} contain wrong quantity of element's
	 *                         or {@code null}
	 */
	boolean isValid(String[] elementsString) throws CustomException;

	/**
	 * Return {@code true} if {@param unsignedDouble} contain unsigned double,
	 * else return {@code false}
	 *
	 * @param unsignedDouble is {@code String} for validation
	 * @return {@code true} if {@param unsignedDouble} contain unsigned double
	 */
	default boolean isValidUnsignedDouble(String unsignedDouble) {
		return unsignedDouble.matches(UNSIGNED_DOUBLE_PATTERN);
	}
}