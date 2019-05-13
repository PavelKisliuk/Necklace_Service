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
import xxx.pavelkisliuk.necklaceservice.model.IProduct;
import xxx.pavelkisliuk.necklaceservice.model.Stone;
import xxx.pavelkisliuk.necklaceservice.validator.StoneChecker;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Creator of {@code Stone} implementation of the {@code IFactory} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IFactory
 * @see GemstoneCreator
 * @see CanvasCreator
 * @see NecklaceElementCreator
 * @see NecklaceCreator
 * @see IProduct
 * @see Stone
 * @since 12.0
 */
public class StoneCreator implements IFactory {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Create {@code IProduct} instance of {@code Stone} and return it
	 * <p>
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 */
	@Override
	public Stone create(String[] elementsString) {
		if (!(new StoneChecker().isValid(elementsString))) {
			LOGGER.log(Level.ERROR, ("Incorrect elementsString ->" + Arrays.toString(elementsString)));
			return LOGGER.traceExit(new Stone());
		}

		Stone stone = new Stone();
		stone.setName(elementsString[StoneChecker.NAME_PLACE].trim());
		stone.setStoneId(elementsString[StoneChecker.ID_PLACE].trim());
		stone.setWeight(Double.valueOf(elementsString[StoneChecker.WEIGHT_PLACE].trim()));
		stone.setCost(BigDecimal.valueOf(
				Double.valueOf(elementsString[StoneChecker.COST_PLACE].trim())));
		return LOGGER.traceExit(stone);
	}
}