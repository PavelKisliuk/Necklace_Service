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

import java.util.Arrays;

/**
 * Checker of {@code Necklace} implementation of the {@code IChecker} interface.
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IChecker
 * @see StoneChecker
 * @see GemstoneChecker
 * @see CanvasChecker
 * @see NecklaceElementChecker
 * @see NecklaceChecker
 * @see xxx.necklaceservice.model.Necklace
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
	 *
	 * @param id is {@code String} representation of {@code Necklace} field {@code idSNecklace}
	 * @return {@code true} if {@param id} is correct for assignment
	 * to field {@code idNecklace} of {@code Necklace}
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
	 * Return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsList} of {@code Necklace}, else return {@code false}
	 *
	 * @param necklaceElementsGroup is {@code String} representation of {@code Necklace} field
	 *                              {@code necklaceElementsGroup}
	 * @return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsGroup} of {@code Necklace}
	 * @throws CustomException if {@param necklaceElementsGroup} is {@code null}
	 */
	public boolean isValidNecklaceElementsList(String necklaceElementsGroup) throws CustomException {
		if (necklaceElementsGroup == null) {
			LOGGER.log(Level.ERROR, "Problem with String canvas -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + necklaceElementsGroup);
		return LOGGER.traceExit(isValidNecklaceElementsList(necklaceElementsGroup.split("~")));
	}

	/**
	 * Return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsList} of {@code Necklace}, else return {@code false}
	 *
	 * @param necklaceElementsGroup is {@code String} representation of {@code Necklace} field
	 *                              {@code necklaceElementsGroup}
	 * @return {@code true} if {@param necklaceElementsGroup} is correct for assignment
	 * to field {@code necklaceElementsGroup} of {@code Necklace}
	 * @throws CustomException if {@param necklaceElementsGroup} is {@code null}
	 */
	public boolean isValidNecklaceElementsList(String[] necklaceElementsGroup) throws CustomException {
		if (necklaceElementsGroup == null) {
			LOGGER.log(Level.ERROR, "Problem with String necklaceElementsList -> " + null);
			throw new CustomException();
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
	 *
	 * @param cost is {@code String} representation of {@code Necklace} field {@code costD}
	 * @return {@code true} if {@param cost} is correct for assignment
	 * to field {@code costD} of {@code Necklace}
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
}
