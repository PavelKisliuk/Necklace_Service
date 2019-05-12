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
 * Checker of {@code Stone} implementation of the {@code IChecker} interface.
 * @author Kisliuk Pavel Sergeevich
 * @see IChecker
 * @see xxx.necklaceservice.model.Stone
 * @since 12.0
 */
public class StoneChecker implements IChecker {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Represent a quantity elements {@code Stone}
	 */
	public static final int ELEMENTS_QUANTITY = 4;

	/**
	 * Represent a number of element of {@code Stone} {@code name} in {@code String}
	 * array for correct validation
	 */
	public static final int NAME_PLACE = 0;

	/**
	 * Represent a number of element of {@code Stone} {@code id} in {@code String}
	 * array for correct validation
	 */
	public static final int ID_PLACE = 1;

	/**
	 * Represent a number of element of {@code Stone} {@code weightCt} in {@code String}
	 * array for correct validation
	 */
	public static final int WEIGHT_PLACE = 2;

	/**
	 * Represent a number of element of {@code Stone} {@code costD} in {@code String}
	 * array for correct validation
	 */
	public static final int COST_PLACE = 3;

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
			LOGGER.log(Level.ERROR, "Problem with String path -> " + Arrays.toString(elementsString));
			throw new CustomException();
		}

		if (!(isValidName(elementsString[NAME_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect name -> " + elementsString[NAME_PLACE]);
			return false;
		}

		if (!(isValidId(elementsString[ID_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect id -> " + elementsString[ID_PLACE]);
			return false;
		}

		if (!(isValidWeight(elementsString[WEIGHT_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect weight -> " + elementsString[WEIGHT_PLACE]);
			return false;
		}

		if (!(isValidCost(elementsString[COST_PLACE]))) {
			LOGGER.log(Level.WARN, "Incorrect cost -> " + elementsString[COST_PLACE]);
			return false;
		}

		return true;
	}

	/**
	 * Return {@code true} if {@param name} is correct for assignment
	 * to field {@code name} of {@code Stone}, else return {@code false}
	 * @param name is {@code String} representation of {@code Stone} field {@code name}
	 * @return {@code true} if {@param name} is correct for assignment
	 * to field {@code name} of {@code Stone}
	 * @throws CustomException if {@param name} is {@code null}
	 */
	public boolean isValidName(String name) throws CustomException {
		if (name == null) {
			LOGGER.log(Level.ERROR, "Problem with String name -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + name);
		return LOGGER.traceExit(name.trim().matches("[a-zA-Z]+"));
	}

	/**
	 * Return {@code true} if {@param id} is correct for assignment
	 * to field {@code id} of {@code Stone}, else return {@code false}
	 * @param id is {@code String} representation of {@code Stone} field {@code id}
	 * @return {@code true} if {@param id} is correct for assignment
	 * to field {@code id} of {@code Stone}
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
	 * to field {@code weightCt} of {@code Stone}, else return {@code false}
	 * @param weight is {@code String} representation of {@code Stone} field {@code weightCt}
	 * @return {@code true} if {@param weight} is correct for assignment
	 * to field {@code weightCt} of {@code Stone}
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
	 * to field {@code costD} of {@code Stone}, else return {@code false}
	 * @param cost is {@code String} representation of {@code Stone} field {@code costD}
	 * @return {@code true} if {@param cost} is correct for assignment
	 * to field {@code costD} of {@code Stone}
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