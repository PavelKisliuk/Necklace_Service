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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;

import java.util.Arrays;

/**
 * Checker of {@code NecklaceElement} implementation of the {@code IChecker} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IChecker
 * @see StoneChecker
 * @see GemstoneChecker
 * @see CanvasChecker
 * @see NecklaceElementChecker
 * @see NecklaceChecker
 * @see NecklaceElement
 * @since 12.0
 */
public class NecklaceElementChecker implements IChecker {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Represent a minimal quantity elements {@code NecklaceElement}
	 */
	public static final int MIN_ELEMENTS_QUANTITY = 2;

	/**
	 * Represent a number of element of {@code NecklaceElement} {@code canvas} in {@code String}
	 * array for correct validation
	 */
	public static final int CANVAS_PLACE = 0;

	/**
	 * Represent a number of elements of {@code NecklaceElement} {@code stonesGroup} in {@code String}
	 * array for correct validation
	 */
	public static final int STONES_GROUP_PLACE_FROM = 1;

	/**
	 * Return {@code true} if all element's of {@param elementsString} are valid,
	 * else return {@code false}
	 * <p>
	 *
	 * @param elementsString is array of {@code String} for validation
	 * @return {@code true} if all element's of {@param elementsString} are valid
	 */
	@Override
	public boolean isValid(String[] elementsString) {
		if (elementsString == null) {
			LOGGER.log(Level.WARN, "Problem with elementsString -> " + null);
			return LOGGER.traceExit(false);
		}

		if (elementsString.length < MIN_ELEMENTS_QUANTITY) {
			LOGGER.log(Level.WARN, "Incorrect quantity of elements");
			return LOGGER.traceExit(false);
		}

		if (!(isValidCanvas(elementsString[CANVAS_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect canvas -> " + elementsString[CANVAS_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidStonesGroup(Arrays.copyOfRange(elementsString, STONES_GROUP_PLACE_FROM,
				(elementsString.length))))) {
			LOGGER.log(Level.WARN, "Incorrect stonesGroup");
			return LOGGER.traceExit(false);
		}

		return LOGGER.traceExit(true);
	}

	/**
	 * Return {@code true} if {@param canvas} is correct for assignment
	 * to field {@code canvas} of {@code NecklaceElement}, else return {@code false}
	 * <p>
	 *
	 * @param canvas is {@code String} representation of {@code NecklaceElement} field {@code canvas}
	 * @return {@code true} if {@param canvas} is correct for assignment
	 * to field {@code canvas} of {@code NecklaceElement}
	 */
	public boolean isValidCanvas(String canvas) {
		if (canvas == null) {
			LOGGER.log(Level.WARN, "Problem with String canvas -> " + null);
			return LOGGER.traceExit(false);
		}
		LOGGER.log(Level.DEBUG, "Check -> " + canvas);
		return LOGGER.traceExit(new CanvasChecker().isValid(canvas.split("-")));
	}

	/**
	 * Return {@code true} if {@param stonesGroup} is correct for assignment
	 * to field {@code stonesGroup} of {@code NecklaceElement}, else return {@code false}
	 * <p>
	 *
	 * @param stonesGroup is {@code String} representation of {@code NecklaceElement} field {@code stonesGroup}
	 * @return {@code true} if {@param stonesGroup} is correct for assignment
	 * to field {@code stonesGroup} of {@code NecklaceElement}
	 */
	public boolean isValidStonesGroup(String stonesGroup) {
		if (stonesGroup == null) {
			LOGGER.log(Level.WARN, "Problem with String stonesGroup -> " + null);
			return LOGGER.traceExit(false);
		}
		LOGGER.log(Level.DEBUG, "Check -> " + stonesGroup);

		return LOGGER.traceExit(isValidStonesGroup(stonesGroup.split("#")));
	}

	/**
	 * Return {@code true} if {@param stonesGroup} is correct for assignment
	 * to field {@code stonesGroup} of {@code NecklaceElement}, else return {@code false}
	 * <p>
	 *
	 * @param stonesGroup is {@code String} representation of {@code NecklaceElement} field {@code stonesGroup}
	 * @return {@code true} if {@param stonesGroup} is correct for assignment
	 * to field {@code stonesGroup} of {@code NecklaceElement}
	 */
	public boolean isValidStonesGroup(String[] stonesGroup) {
		if (stonesGroup == null) {
			LOGGER.log(Level.WARN, "Problem with String stonesGroup -> " + null);
			return LOGGER.traceExit(false);
		}
		LOGGER.log(Level.DEBUG, "Check -> " + Arrays.toString(stonesGroup));

		int i = 0;
		while (i < stonesGroup.length) {
			String[] splitedStone = stonesGroup[i].split("-");

			if (!((splitedStone.length != StoneChecker.ELEMENTS_QUANTITY) ?
					(new GemstoneChecker().isValid(splitedStone)) :
					(new StoneChecker().isValid(splitedStone)))) {
				return LOGGER.traceExit(false);
			}
			i++;
		}
		return LOGGER.traceExit(true);
	}
}