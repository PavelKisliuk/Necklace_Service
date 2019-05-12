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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Gemstone;

import java.util.Arrays;

/**
 * Checker of {@code Gemstone} implementation of the {@code IChecker} interface.
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IChecker
 * @see StoneChecker
 * @see GemstoneChecker
 * @see CanvasChecker
 * @see NecklaceElementChecker
 * @see NecklaceChecker
 * @see Gemstone
 * @since 12.0
 */
public class GemstoneChecker extends StoneChecker implements IChecker {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Represent a quantity elements {@code Gemstone}
	 */
	public static final int ELEMENTS_QUANTITY = 7;

	/**
	 * Represent a number of element of {@code Gemstone} {@code curiosityLevel} in {@code String}
	 * array for correct validation
	 */
	public static final int CURIOSITY_PLACE = 4;

	/**
	 * Represent a number of element of {@code Gemstone} {@code hardnessLevel} in {@code String}
	 * array for correct validation
	 */
	public static final int HARDNESS_PLACE = 5;

	/**
	 * Represent a number of element of {@code Gemstone} {@code opacity} in {@code String}
	 * array for correct validation
	 */
	public static final int OPACITY_PLACE = 6;

	/**
	 * Return {@code true} if all element's of {@param elementsString} are valid,
	 * else return {@code false}
	 *
	 * @param elementsString is array of {@code String} for validation
	 * @return {@code true} if all element's of {@param elementsString} are valid
	 * @throws CustomException if {@param elementsString} contain wrong quantity of element's
	 *                         or {@code null}
	 */
	@Override
	public boolean isValid(String[] elementsString) throws CustomException {
		if ((elementsString == null) ||
				elementsString.length != ELEMENTS_QUANTITY) {
			LOGGER.log(Level.ERROR, "Problem with elementsString -> " + Arrays.toString(elementsString));
			throw new CustomException();
		}

		if (!(super.isValid(Arrays.copyOfRange(elementsString, 0, (StoneChecker.ELEMENTS_QUANTITY))))) {
			return LOGGER.traceExit(false);
		}

		if (!(isValidCuriosity(elementsString[CURIOSITY_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect curiosity -> " + elementsString[CURIOSITY_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidHardness(elementsString[HARDNESS_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect hardness -> " + elementsString[HARDNESS_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidOpacity(elementsString[OPACITY_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect opacity -> " + elementsString[OPACITY_PLACE]);
			return LOGGER.traceExit(false);
		}

		return LOGGER.traceExit(true);
	}

	/**
	 * Return {@code true} if {@param curiosity} is correct for assignment
	 * to field {@code curiosityLevel} of {@code Stone}, else return {@code false}
	 *
	 * @param curiosity is {@code String} representation of {@code Stone} field {@code curiosityLevel}
	 * @return {@code true} if {@param curiosity} is correct for assignment
	 * to field {@code curiosityLevel} of {@code Stone}
	 * @throws CustomException if {@param curiosity} is {@code null}
	 */
	public boolean isValidCuriosity(String curiosity) throws CustomException {
		if (curiosity == null) {
			LOGGER.log(Level.ERROR, "Problem with String curiosity -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + curiosity);
		return LOGGER.traceExit(
				Arrays.stream(
						Gemstone.CuriosityLevel.values()).anyMatch(
						e -> e.name().equals(curiosity.toUpperCase().trim())));
	}

	/**
	 * Return {@code true} if {@param hardness} is correct for assignment
	 * to field {@code hardnessLevel} of {@code Stone}, else return {@code false}
	 *
	 * @param hardness is {@code String} representation of {@code Stone} field {@code hardnessLevel}
	 * @return {@code true} if {@param hardness} is correct for assignment
	 * to field {@code hardnessLevel} of {@code Stone}
	 * @throws CustomException if {@param hardness} is {@code null}
	 */
	public boolean isValidHardness(String hardness) throws CustomException {
		if (hardness == null) {
			LOGGER.log(Level.ERROR, "Problem with String hardness -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + hardness);
		return LOGGER.traceExit(
				Arrays.stream(
						Gemstone.HardnessLevel.values()).anyMatch(
						e -> e.name().equals(hardness.toUpperCase().trim())));
	}

	/**
	 * Return {@code true} if {@param opacity} is correct for assignment
	 * to field {@code opacity} of {@code Stone}, else return {@code false}
	 *
	 * @param opacity is {@code String} representation of {@code Stone} field {@code opacity}
	 * @return {@code true} if {@param opacity} is correct for assignment
	 * to field {@code opacity} of {@code Stone}
	 * @throws CustomException if {@param opacity} is {@code null}
	 */
	public boolean isValidOpacity(String opacity) throws CustomException {
		if (opacity == null) {
			LOGGER.log(Level.ERROR, "Problem with String opacity -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + opacity);
		return LOGGER.traceExit((isValidUnsignedDouble(opacity.trim())) &&
				(Double.compare(Double.valueOf(opacity.trim()), Gemstone.MIN_OPACITY) >= 0) &&
				(Double.compare(Double.valueOf(opacity.trim()), Gemstone.MAX_OPACITY)) <= 0);
	}
}