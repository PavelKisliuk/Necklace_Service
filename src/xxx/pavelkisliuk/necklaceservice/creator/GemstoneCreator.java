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

package xxx.pavelkisliuk.necklaceservice.creator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.IProduct;
import xxx.pavelkisliuk.necklaceservice.validator.GemstoneChecker;
import xxx.pavelkisliuk.necklaceservice.validator.StoneChecker;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Creator of {@code Gemstone} implementation of the {@code IFactory} interface.
 * <p>
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
	 * <p>
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 */
	@Override
	public Gemstone create(String[] elementsString) {
		if (!(new GemstoneChecker().isValid(elementsString))) {
			LOGGER.log(Level.ERROR, ("Incorrect elementsString ->" + Arrays.toString(elementsString)));
			return LOGGER.traceExit(new Gemstone());
		}

		Gemstone gemstone = new Gemstone();
		gemstone.setName(elementsString[StoneChecker.NAME_PLACE].trim());
		gemstone.setStoneId(elementsString[StoneChecker.ID_PLACE].trim());
		gemstone.setWeight(Double.valueOf(elementsString[StoneChecker.WEIGHT_PLACE].trim()));
		gemstone.setCost(BigDecimal.valueOf(
				Double.valueOf(elementsString[StoneChecker.COST_PLACE].trim())));
		gemstone.setCuriosityLevelType(
				Gemstone.CuriosityLevelType.valueOf(
						elementsString[GemstoneChecker.CURIOSITY_PLACE].toUpperCase().trim()));
		gemstone.setHardnessLevelType(
				Gemstone.HardnessLevelType.valueOf(
						elementsString[GemstoneChecker.HARDNESS_PLACE].toUpperCase().trim()));
		gemstone.setOpacity(Double.valueOf(elementsString[GemstoneChecker.OPACITY_PLACE].trim()));
		return LOGGER.traceExit(gemstone);
	}
}