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
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;
import xxx.pavelkisliuk.necklaceservice.model.IProduct;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;
import xxx.pavelkisliuk.necklaceservice.validator.NecklaceElementChecker;
import xxx.pavelkisliuk.necklaceservice.validator.StoneChecker;

import java.util.Arrays;

/**
 * Creator of {@code NecklaceElement} implementation of the {@code IFactory} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IFactory
 * @see StoneCreator
 * @see GemstoneCreator
 * @see CanvasCreator
 * @see NecklaceCreator
 * @see IProduct
 * @see NecklaceElement
 * @since 12.0
 */
public class NecklaceElementCreator implements IFactory {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Create {@code IProduct} instance of {@code NecklaceElement} and return it
	 * <p>
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 * @throws CustomException if {@param elementsString} is incorrect
	 */
	@Override
	public NecklaceElement create(String[] elementsString) throws CustomException {
		if (!(new NecklaceElementChecker().isValid(elementsString))) {
			LOGGER.log(Level.ERROR, ("Incorrect elementsString ->" + Arrays.toString(elementsString)));
			return LOGGER.traceExit(new NecklaceElement());
		}

		NecklaceElement necklaceElement = new NecklaceElement();
		necklaceElement.setCanvas(new CanvasCreator().create(
				elementsString[NecklaceElementChecker.CANVAS_PLACE].trim().split("-")));
		for (String stone :
				Arrays.copyOfRange(
						elementsString, NecklaceElementChecker.STONES_GROUP_PLACE_FROM, elementsString.length)) {
			String[] splitedStone = stone.trim().split("-");
			necklaceElement.getStonesGroup().add((splitedStone.length != StoneChecker.ELEMENTS_QUANTITY) ?
					new GemstoneCreator().create(splitedStone) :
					new StoneCreator().create(splitedStone));
		}
		return LOGGER.traceExit(necklaceElement);
	}
}