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
import xxx.necklaceservice.model.IProduct;
import xxx.necklaceservice.model.Stone;
import xxx.necklaceservice.validator.StoneChecker;

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
	 * @throws CustomException if {@param elementsString} is incorrect
	 */
	@Override
	public Stone create(String[] elementsString) throws CustomException {
		if (!(new StoneChecker().isValid(elementsString))) {
			LOGGER.log(Level.ERROR, ("Incorrect elementsString ->" + Arrays.toString(elementsString)));
			return LOGGER.traceExit(new Stone());
		}

		Stone stone = new Stone();
		stone.setName(elementsString[StoneChecker.NAME_PLACE].trim());
		stone.setIdStone(elementsString[StoneChecker.ID_PLACE].trim());
		stone.setCtWeight(Double.valueOf(elementsString[StoneChecker.WEIGHT_PLACE].trim()));
		stone.setCostD(Double.valueOf(elementsString[StoneChecker.COST_PLACE].trim()));
		return LOGGER.traceExit(stone);
	}
}