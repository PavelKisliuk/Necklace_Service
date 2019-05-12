/*
 * By Pavel Kisliuk, 10.05.2019
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

package xxx.necklaceservice.creator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Gemstone;
import xxx.necklaceservice.model.IProduct;
import xxx.necklaceservice.validator.GemstoneChecker;
import xxx.necklaceservice.validator.StoneChecker;

import java.util.Arrays;

/**
 * Creator of {@code Gemstone} implementation of the {@code IFactory} interface.
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IFactory
 * @see StoneCreator
 * @see CanvasCreator
 * @see NecklaceElementCreator
 * @see NecklaceCreator
 * @see IProduct
 * @see Gemstone
 * @since 12.0
 */
public class GemstoneCreator implements IFactory {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Create {@code IProduct} instance of {@code Gemstone} and return it
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 * @throws CustomException if {@param elementsString} is incorrect
	 */
	@Override
	public Gemstone create(String[] elementsString) throws CustomException {
		if (!(new GemstoneChecker().isValid(elementsString))) {
			LOGGER.log(Level.ERROR, ("Incorrect elementsString ->" + Arrays.toString(elementsString)));
			return LOGGER.traceExit(new Gemstone());
		}

		Gemstone gemstone = new Gemstone();
		gemstone.setName(elementsString[StoneChecker.NAME_PLACE].trim());
		gemstone.setIdStone(elementsString[StoneChecker.ID_PLACE].trim());
		gemstone.setCtWeight(Double.valueOf(elementsString[StoneChecker.WEIGHT_PLACE].trim()));
		gemstone.setCostD(Double.valueOf(elementsString[StoneChecker.COST_PLACE].trim()));
		gemstone.setCuriosityLevel(
				Gemstone.CuriosityLevel.valueOf(
						elementsString[GemstoneChecker.CURIOSITY_PLACE].toUpperCase().trim()));
		gemstone.setHardnessLevel(
				Gemstone.HardnessLevel.valueOf(
						elementsString[GemstoneChecker.HARDNESS_PLACE].toUpperCase().trim()));
		gemstone.setOpacity(Double.valueOf(elementsString[GemstoneChecker.OPACITY_PLACE].trim()));
		return LOGGER.traceExit(gemstone);
	}
}