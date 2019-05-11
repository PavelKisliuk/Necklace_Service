package xxx.necklaceservice.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.necklaceservice.exception.CustomException;

import java.util.Arrays;

public class StoneChecker implements IChecker {
	private static final Logger LOGGER = LogManager.getLogger();

	public static final int ELEMENTS_QUANTITY = 4;
	public static final int NAME_PLACE = 0;
	public static final int ID_PLACE = 1;
	public static final int WEIGHT_PLACE = 2;
	public static final int COST_PLACE = 3;

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

	public boolean isValidName(String name) throws CustomException {
		if (name == null) {
			LOGGER.log(Level.ERROR, "Problem with String name -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + name);
		return LOGGER.traceExit(name.matches("[a-zA-Z]+"));
	}

	public boolean isValidId(String id) throws CustomException {
		if (id == null) {
			LOGGER.log(Level.ERROR, "Problem with String id -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + id);
		return LOGGER.traceExit(id.matches("[a-zA-Z]+\\d+"));
	}

	public boolean isValidWeight(String weight) throws CustomException {
		if (weight == null) {
			LOGGER.log(Level.ERROR, "Problem with String weight -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + weight);
		return LOGGER.traceExit(isValidUnsignedDouble(weight));
	}

	public boolean isValidCost(String cost) throws CustomException {
		if (cost == null) {
			LOGGER.log(Level.ERROR, "Problem with String cost -> " + null);
			throw new CustomException();
		}
		LOGGER.log(Level.DEBUG, "Check -> " + cost);
		return LOGGER.traceExit(isValidUnsignedDouble(cost));
	}
}
