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

package xxx.pavelkisliuk.necklaceservice.validator;

/**
 * The {@code IChecker} interface provide method for validation data from
 * array of {@code String}
 * <p>
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
	 * value as unsigned double
	 */
	String UNSIGNED_DOUBLE_PATTERN = "\\d+(\\.\\d+)?";

	/**
	 * Return {@code true} if all element's of {@param elementsString} are valid,
	 * else return {@code false}
	 * <p>
	 *
	 * @param elementsString is array of {@code String} for validation
	 * @return {@code true} if all element's of {@param elementsString} are valid
	 */
	boolean isValid(String[] elementsString);

	/**
	 * Return {@code true} if {@param unsignedDouble} contain unsigned double,
	 * else return {@code false}
	 * <p>
	 *
	 * @param unsignedDouble is {@code String} for validation
	 * @return {@code true} if {@param unsignedDouble} contain unsigned double
	 */
	default boolean isValidUnsignedDouble(String unsignedDouble) {
		return unsignedDouble.matches(UNSIGNED_DOUBLE_PATTERN);
	}
}