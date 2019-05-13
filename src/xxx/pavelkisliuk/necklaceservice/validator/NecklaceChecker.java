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
import xxx.pavelkisliuk.necklaceservice.model.Necklace;

import java.util.Arrays;

/**
 * Checker of {@code Necklace} implementation of the {@code IChecker} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IChecker
 * @see StoneChecker
 * @see GemstoneChecker
 * @see CanvasChecker
 * @see NecklaceElementChecker
 * @see Necklace
 * @since 12.0
 */
public class NecklaceChecker implements IChecker {
	private static final Logger LOGGER = LogManager.getLogger();
	/**
	 * Represent a quantity elements {@code Necklace}
	 */
	public static final int ELEMENTS_QUANTITY = 3;

	/**
	 * Represent a number of element of {@code Necklace} {@code id} in {@code String}
	 * array for correct validation
	 */
	public static final int ID_PLACE = 0;

	/**
	 * Represent a number of elements of {@code Necklace} {@code necklaceElementsList} in {@code String}
	 * array for correct validation
	 */
	public static final int NECLACE_ELEMENTS_LIST_PLACE = 1;

	/**
	 * Represent a number of elements of {@code Necklace} {@code costD} in {@code String}
	 * array for correct validation
	 */
	public static final int COST_PLACE = 2;

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

		if (elementsString.length != ELEMENTS_QUANTITY) {
			LOGGER.log(Level.WARN, "Incorrect quantity of elements");
			return LOGGER.traceExit(false);
		}

		if (!(isValidId(elementsString[ID_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect id -> " + elementsString[ID_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidNecklaceElementsList(elementsString[NECLACE_ELEMENTS_LIST_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect necklace elements list -> "
					+ elementsString[NECLACE_ELEMENTS_LIST_PLACE]);
			return LOGGER.traceExit(false);
		}

		if (!(isValidCost(elementsString[COST_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect cost -> " + elementsString[COST_PLACE]);
			return LOGGER.traceExit(false);
		}

		return LOGGER.traceExit(true);
	}

	/**
	 * Return {@code true} if {@param id} is correct for assignment
	 * to field {@code idNecklace} of {@code Necklace}, else return {@code false}
	 * <p>
	 *
	 * @param id is {@code String} representation of {@code Necklace} field {@code idSNecklace}
	 * @return {@code true} if {@param id} is correct for assignment
	 * to field {@code idNecklace} of {@code Necklace}
	 */
	public boolean isValidId(String id) {
		if (id == null) {
			LOGGER.log(Level.WARN, "Problem with String id -> " + null);
			return LOGGER.traceExit(false);
		}
		LOGGER.log(Level.DEBUG, "Check -> " + id);
		return LOGGER.traceExit(id.trim().matches("[a-zA-Z]+\\d+"));
	}

	/**
	 * Return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsList} of {@code Necklace}, else return {@code false}
	 * <p>
	 *
	 * @param necklaceElementsGroup is {@code String} representation of {@code Necklace} field
	 *                              {@code necklaceElementsGroup}
	 * @return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsGroup} of {@code Necklace}
	 */
	public boolean isValidNecklaceElementsList(String necklaceElementsGroup) {
		if (necklaceElementsGroup == null) {
			LOGGER.log(Level.WARN, "Problem with String canvas -> " + null);
			return LOGGER.traceExit(false);
		}
		LOGGER.log(Level.DEBUG, "Check -> " + necklaceElementsGroup);
		return LOGGER.traceExit(isValidNecklaceElementsList(necklaceElementsGroup.split("~")));
	}

	/**
	 * Return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsList} of {@code Necklace}, else return {@code false}
	 * <p>
	 *
	 * @param necklaceElementsGroup is {@code String} representation of {@code Necklace} field
	 *                              {@code necklaceElementsGroup}
	 * @return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsGroup} of {@code Necklace}
	 */
	public boolean isValidNecklaceElementsList(String[] necklaceElementsGroup) {
		if (necklaceElementsGroup == null) {
			LOGGER.log(Level.WARN, "Problem with String necklaceElementsList -> " + null);
			return LOGGER.traceExit(false);
		}
		LOGGER.log(Level.DEBUG, "Check -> " + Arrays.toString(necklaceElementsGroup));

		int i = 0;
		while (i < necklaceElementsGroup.length) {
			String[] splitednecklaceElementsList = necklaceElementsGroup[i].split("#");

			if (!(new NecklaceElementChecker().isValid(splitednecklaceElementsList))) {
				return LOGGER.traceExit(false);
			}
			i++;
		}
		return LOGGER.traceExit(true);
	}

	/**
	 * Return {@code true} if {@param cost} is correct for assignment
	 * to field {@code costD} of {@code Necklace}, else return {@code false}
	 * <p>
	 *
	 * @param cost is {@code String} representation of {@code Necklace} field {@code costD}
	 * @return {@code true} if {@param cost} is correct for assignment
	 * to field {@code costD} of {@code Necklace}
	 */
	public boolean isValidCost(String cost) {
		if (cost == null) {
			LOGGER.log(Level.WARN, "Problem with String cost -> " + null);
			return LOGGER.traceExit(false);
		}
		LOGGER.log(Level.DEBUG, "Check -> " + cost);
		return LOGGER.traceExit(isValidUnsignedDouble(cost.trim()));
	}
}