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
import xxx.necklaceservice.model.Canvas;
import xxx.necklaceservice.model.IProduct;
import xxx.necklaceservice.validator.CanvasChecker;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Creator of {@code Canvas} implementation of the {@code IFactory} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IFactory
 * @see StoneCreator
 * @see GemstoneCreator
 * @see NecklaceElementCreator
 * @see NecklaceCreator
 * @see IProduct
 * @see Canvas
 * @since 12.0
 */
public class CanvasCreator implements IFactory {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Create {@code IProduct} instance of {@code Canvas} and return it
	 * <p>
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 * @throws CustomException if {@param elementsString} is incorrect
	 */
	@Override
	public Canvas create(String[] elementsString) throws CustomException {
		if (!(new CanvasChecker().isValid(elementsString))) {
			LOGGER.log(Level.ERROR, ("Incorrect elementsString ->" + Arrays.toString(elementsString)));
			return LOGGER.traceExit(new Canvas());
		}

		Canvas canvas = new Canvas();
		canvas.setCanvasId(elementsString[CanvasChecker.ID_PLACE].trim());
		canvas.setWeight(Double.valueOf(elementsString[CanvasChecker.WEIGHT_PLACE].trim()));
		canvas.setCost(BigDecimal.valueOf(
				Double.valueOf(elementsString[CanvasChecker.COST_PLACE].trim())));
		canvas.setMetal(Canvas.Metal.valueOf(elementsString[CanvasChecker.METAL_PLACE].toUpperCase().trim()));
		return LOGGER.traceExit(canvas);
	}
}