/*
 * By Pavel Kisliuk, 12.05.2019
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
import xxx.necklaceservice.model.Canvas;

import java.util.Arrays;

/**
 * Checker of {@code Canvas} implementation of the {@code IChecker} interface.
 * @author Kisliuk Pavel Sergeevich
 * @see IChecker
 * @see xxx.necklaceservice.model.Stone
 * @since 12.0
 */
public class CanvasChecker implements IChecker {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Represent a quantity elements {@code Canvas}
	 */
	public static final int ELEMENTS_QUANTITY = 4;

	/**
	 * Represent a number of element of {@code Canvas} {@code idCanvas} in {@code String}
	 * array for correct validation
	 */
	public static final int ID_PLACE = 0;

	/**
	 * Represent a number of element of {@code Canvas} {@code grWeight} in {@code String}
	 * array for correct validation
	 */
	public static final int WEIGHT_PLACE = 1;

	/**
	 * Represent a number of element of {@code Canvas} {@code costD} in {@code String}
	 * array for correct validation
	 */
	public static final int COST_PLACE = 2;

	/**
	 * Represent a number of element of {@code Canvas} {@code metal} in {@code String}
	 * array for correct validation
	 */
	public static final int METAL_PLACE = 3;


	/**
	 * Return {@code true} if all element's of {@param elementsString} are valid,
	 * else return {@code false}
	 * @param elementsString is array of {@code String} for validation
	 * @return {@code true} if all element's of {@param elementsString} are valid
	 * @throws CustomException if {@param elementsString} contain wrong quantity of element's
	 * or {@code null}
	 */
	@Override
	public boolean isValid(String[] elementsString) throws CustomException {
		if ((elementsString == null) ||
				elementsString.length != ELEMENTS_QUANTITY) {
			LOGGER.log(Level.ERROR, "Problem with elementsString -> " + Arrays.toString(elementsString));
			throw new CustomException();
		}

		if (!(isValidId(elementsString[ID_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect id -> " + elementsString[ID_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidWeight(elementsString[WEIGHT_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect weight -> " + elementsString[WEIGHT_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidCost(elementsString[COST_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect cost -> " + elementsString[COST_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidMetal(elementsString[METAL_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect metal -> " + elementsString[METAL_PLACE]);
			return LOGGER.traceExit(false);
		}

		return LOGGER.traceExit(true);
	}

	/**
	 * Return {@code true} if {@param id} is correct for assignment
	 * to field {@code idCanvas} of {@code Canvas}, else return {@code false}
	 * @param id is {@code String} representation of {@code Canvas} field {@code idCanvas}
	 * @return {@code true} if {@param id} is correct for assignment
	 * to field {@code idCanvas} of {@code Canvas}
	 * @throws CustomException if {@param id} is {@code null}
	 */
	public boolean isValidId(String id) throws CustomException {
		if (id == null) {
			LOGGER.log(Level.ERROR, "Problem with String id -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + id);
		return LOGGER.traceExit(id.trim().matches("[a-zA-Z]+\\d+"));
	}

	/**
	 * Return {@code true} if {@param weight} is correct for assignment
	 * to field {@code grWeight} of {@code Canvas}, else return {@code false}
	 * @param weight is {@code String} representation of {@code Canvas} field {@code grWeight}
	 * @return {@code true} if {@param weight} is correct for assignment
	 * to field {@code grWeight} of {@code Canvas}
	 * @throws CustomException if {@param weight} is {@code null}
	 */
	public boolean isValidWeight(String weight) throws CustomException {
		if (weight == null) {
			LOGGER.log(Level.ERROR, "Problem with String weight -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + weight);
		return LOGGER.traceExit(isValidUnsignedDouble(weight.trim()));
	}

	/**
	 * Return {@code true} if {@param cost} is correct for assignment
	 * to field {@code costD} of {@code Canvas}, else return {@code false}
	 * @param cost is {@code String} representation of {@code Canvas} field {@code costD}
	 * @return {@code true} if {@param cost} is correct for assignment
	 * to field {@code costD} of {@code Canvas}
	 * @throws CustomException if {@param cost} is {@code null}
	 */
	public boolean isValidCost(String cost) throws CustomException {
		if (cost == null) {
			LOGGER.log(Level.ERROR, "Problem with String cost -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + cost);
		return LOGGER.traceExit(isValidUnsignedDouble(cost.trim()));
	}

	/**
	 * Return {@code true} if {@param metal} is correct for assignment
	 * to field {@code metal} of {@code Canvas}, else return {@code false}
	 * @param metal is {@code String} representation of {@code Canvas} field {@code metal}
	 * @return {@code true} if {@param metal} is correct for assignment
	 * to field {@code metal} of {@code Canvas}
	 * @throws CustomException if {@param cost} is {@code null}
	 */
	public boolean isValidMetal(String metal) throws CustomException {
		if (metal == null) {
			LOGGER.log(Level.ERROR, "Problem with String metal -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + metal);
		return LOGGER.traceExit(
				Arrays.stream(
						Canvas.Metal.values()).anyMatch(
						e -> e.name().equals(metal.toUpperCase().trim())));
	}
}